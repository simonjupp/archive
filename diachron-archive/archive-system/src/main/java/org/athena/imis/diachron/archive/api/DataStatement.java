package org.athena.imis.diachron.archive.api;

import java.io.InputStream;

import org.athena.imis.diachron.archive.core.dataloader.ArchiveEntityMetadata;

/**
 * 
 * An interface for implementation of Data Statements, i.e. statements that perform write procedures on 
 * the archive store.
 *
 */
public interface DataStatement {

	/**
	 * Updates a diachronic dataset by loading new data to the archive store. 
	 * Accepts an InputStream object that contains the data to be loaded, and 
	 * a URI of the diachronic dataset to be updated.
	 * 
	 * @param input The InputStream that contains the data to be loaded.
	 * @param diachronicDatasetURI The URI of the diachronic dataset to write to.
	 * @throws Exception 
	 */
	public String loadData(InputStream input, String diachronicDatasetURI) throws Exception;
	
	
	/**
	 * Creates a new diachronic dataset in the arhive and associates it with metadata.
	 * 
	 * @param metadata The metadata to be associated with the archive.
	 * @return A string URI of the created diachronic dataset. 
	 */
	public String createDiachronicDataset(ArchiveEntityMetadata metadata);

	/**
	 * Attributes metadata to a Diachronic Dataset. 
	 * Accepts an InputStream object that contains the data to be loaded in JSON-LD, and 
	 * a URI of the diachronic dataset to be updated.
	 * 
	 * @param stream The InputStream that contains the data to be loaded.
	 * @param diachronicDatasetURI The URI of the diachronic dataset to write to.
	 * @throws Exception when the Diachronic Dataset URI doesn't exist in the archive 
	 */
	public void loadDiachronicDatasetMetadata(InputStream stream, String diachronicDatasetURI) throws Exception;

	/**
	 * Attributes metadata to a Diachronic Dataset Instatiation. 
	 * Accepts an InputStream object that contains the data to be loaded in JSON-LD, and 
	 * a URI of the dataset instatiations to be updated.
	 * 
	 * @param stream The InputStream that contains the data to be loaded.
	 * @param datasetURI The URI of the dataset instatiation to write to.
	 * @throws Exception when the Dataset Instatiation URI doesn't exist in the archive
	 */
	public void loadDatasetMetadata(InputStream stream, String datasetURI) throws Exception;
}