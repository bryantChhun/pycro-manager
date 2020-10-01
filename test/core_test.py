import pytest
from pycromanager.core import Bridge


# test construction of main classes
def test_bridge(create_mock_java_socket, mocker):
    """
    test standard construction
    """
    sock = create_mock_java_socket
    mocker.patch.object(sock, 'receive')
    sock.receive.return_value = {'type': 'MOCK'}
    bridge = Bridge()
    assert(bridge._master_socket == sock)


def test_bridge_exception(create_mock_java_socket, mocker):
    """
    test handling of returned Exception
    """
    sock = create_mock_java_socket
    mocker.patch.object(sock, 'receive')
    sock.receive.return_value = {'type': 'exception',
                                 'message': 'MOCK EXCEPTION'}
    with pytest.raises(Exception):
        bridge = Bridge()


def test_bridge_timeout_error(create_mock_java_socket, mocker):
    """
    test handling of TimeoutError
    """
    sock = create_mock_java_socket
    mocker.patch.object(sock, 'receive')
    sock.receive.return_value = None
    with pytest.raises(TimeoutError):
        bridge = Bridge()


def test_construct_java_object(create_mock_java_socket, mocker):
    sock = create_mock_java_socket
    mocker.patch.object(sock, 'receive')
    sock.receive.return_value = {'type': 'MOCK'}
    bridge = Bridge()

    # check handling of java constructor on classpath
    mocker.patch.object(sock, 'receive')
    sock.receive.return_value = {'api': [{'name': 'not_classpath'}]}
    with pytest.raises(Exception):
        bridge.construct_java_object('some_classpath')

    # check handling of _check_method_args
    # todo: this deserves a separate test because we should iterate through java-python type checks
    mocker.patch.object(sock, 'receive')
    sock.receive.return_value = {'api': [{'name': 'some.classpath'}]}
    with pytest.raises(Exception):
        bridge.construct_java_object('some.classpath')


def test_check_method_args():
    # todo: mock a "method with name" -> a dictionary with key name:classpath, arguments:args
    pass

