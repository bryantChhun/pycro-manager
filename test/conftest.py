import pytest
from mock import patch


@pytest.fixture(scope='function')
def create_mock_java_socket():
    with patch("pycromanager.core.JavaSocket") as MockedJavaSocket:
        mjs = MockedJavaSocket()
        yield mjs
