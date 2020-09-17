****************************
Applications
****************************


Have an application you'd like to contribute to this page? Please `reach out <https://github.com/micro-manager/pycro-manager/issues/new>`_!


.. toctree::
	:maxdepth: 1
	:caption: Contents:

	intermittent_Z_T.ipynb
	TZYX_fast_sequencing_z_indexing.ipynb
	guiding_acq_with_neural_network_attention.ipynb


:doc:`intermittent_Z_T`
	
	This notebook shows how to repeatedly acquire a short time series and then a z stack at a set with a set delay in between.

:doc:`TZYX_fast_sequencing_z_indexing`

	This notebook acquires a fast TZYX data series. The camera is run at reduced ROI to achieve higher framerate (here 200 frames per second). Movement of the z stage is "sequenced" to speed up acquisition. The z stage advances to the next position in the sequence when a trigger from the camera is received. This eliminates delays due to software communication.

:doc:`guiding_acq_with_neural_network_attention`

This tutorial shows how to use Pycro-manager to perform analysis driven targeted multimodal/multiscale acquisition for automated collagen fiber-based biomarker identification. We will acquire brightfield images of a H&E stained cancer histology slide at 4x magnification, identify pathology relevant ROIs using a deep learning model based on the 4x image, and zoom into these ROIs to perform the collagen fiber-specific method of second-harmonic generation (SHG) laser scanning at 20x magnification. This allows for disease-relevant, collagen-specific features to be collected automatically and correlated with the gold standard H&E pathology method. We use Pycro-manager to read/write hardware properties (e.g. camera exposure, lamp intensity, turret position, stage position, etc.), change Micro-Manager hardware property configuration groups, acquire images and access the image data as NumPy array, and perform Z-stack acquisition via multi-dimension acquisition events.



