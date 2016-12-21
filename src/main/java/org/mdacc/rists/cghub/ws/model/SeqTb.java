package org.mdacc.rists.cghub.ws.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the SEQ_TB database table.
 * 
 */
@Entity
@Table(name="SEQ_TB")
@NamedQueries({
	@NamedQuery(name="seqtb.findAll", query="SELECT s FROM SeqTb s"),
//	@NamedQuery(name="seqtb.findByAnalysisId", query="SELECT s FROM SeqTb s where s.analysisId = :analysisId"),
	
})

public class SeqTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ROW_ID")
	private int rowId;

	@Column(name="ALIQUOT_ID")
	private String aliquotId;

	@Column(name="ANALYSIS_ID")
	private String analysisId;

	@Column(name="ANALYTE_CODE")
	private String analyteCode;

	private String center;

	private String checksum;

	@Column(name="DATA_URL")
	private String dataUrl;

	@Column(name="DCC_PROJECT")
	private String dccProject;

	@Column(name="DCC_SPECIMEN_TYPE")
	private String dccSpecimenType;

	@Column(name="DISEASE_ABBR")
	private String diseaseAbbr;

	@Column(name="DISEASE_FULL")
	private String diseaseFull;

	private String filename;

	private String filepath;

	private int filesize;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_MODIFIED")
	private Date lastModified;

	@Column(name="LEGACY_ID")
	private String legacyId;

	@Column(name="PARTICIPANT_ID")
	private String participantId;

	private String platform;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PUBLISHED_DATE")
	private Date publishedDate;

	private String refassem;

	@Column(name="SAMPLE_ID")
	private String sampleId;

	@Column(name="SAMPLE_TYPE")
	private String sampleType;
	
	@Column(name="LIBRARY_STRATEGY")
	private String library;

	@Column(name="SEQ_FORMAT")
	private String seqFormat;

	@Column(name="SEQ_SOURCE")
	private String seqSource;

	@Column(name="SPECIMEN_ID")
	private String specimenId;

	private String study;

	@Column(name="TISSUE_TYPE")
	private String tissueType;

	@Column(name="TSS_ID")
	private String tssId;

	//bi-directional many-to-one association to PairTb
	@ManyToOne
	@JoinColumn(name="PAIR_ID")
	private PairTb pairTb;

	public SeqTb() {
	}

	public SeqTb(String aliquotId, String analysisId, String center,
			String checksum, String dataUrl, String filename, String filepath,
			int filesize, Date lastModified, String participantId,
			String platform, Date publishedDate, String refassem,
			String sampleId, String seqFormat, String seqSource, String study,
			String tissueType) {
		super();
		this.aliquotId = aliquotId;
		this.analysisId = analysisId;
		this.center = center;
		this.checksum = checksum;
		this.dataUrl = dataUrl;
		this.filename = filename;
		this.filepath = filepath;
		this.filesize = filesize;
		this.lastModified = lastModified;
		this.participantId = participantId;
		this.platform = platform;
		this.publishedDate = publishedDate;
		this.refassem = refassem;
		this.sampleId = sampleId;
		this.seqFormat = seqFormat;
		this.seqSource = seqSource;
		this.study = study;
		this.tissueType = tissueType;
	}



	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getAliquotId() {
		return this.aliquotId;
	}

	public void setAliquotId(String aliquotId) {
		this.aliquotId = aliquotId;
	}

	public String getAnalysisId() {
		return this.analysisId;
	}

	public void setAnalysisId(String analysisId) {
		this.analysisId = analysisId;
	}

	public String getAnalyteCode() {
		return this.analyteCode;
	}

	public void setAnalyteCode(String analyteCode) {
		this.analyteCode = analyteCode;
	}

	public String getCenter() {
		return this.center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getChecksum() {
		return this.checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getDataUrl() {
		return this.dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public String getDccProject() {
		return this.dccProject;
	}

	public void setDccProject(String dccProject) {
		this.dccProject = dccProject;
	}

	public String getDccSpecimenType() {
		return this.dccSpecimenType;
	}

	public void setDccSpecimenType(String dccSpecimenType) {
		this.dccSpecimenType = dccSpecimenType;
	}

	public String getDiseaseAbbr() {
		return this.diseaseAbbr;
	}

	public void setDiseaseAbbr(String diseaseAbbr) {
		this.diseaseAbbr = diseaseAbbr;
	}

	public String getDiseaseFull() {
		return this.diseaseFull;
	}

	public void setDiseaseFull(String diseaseFull) {
		this.diseaseFull = diseaseFull;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getFilesize() {
		return this.filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getLegacyId() {
		return this.legacyId;
	}

	public void setLegacyId(String legacyId) {
		this.legacyId = legacyId;
	}

	public String getParticipantId() {
		return this.participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Date getPublishedDate() {
		return this.publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getRefassem() {
		return this.refassem;
	}

	public void setRefassem(String refassem) {
		this.refassem = refassem;
	}

	public String getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}

	public String getSampleType() {
		return this.sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	
	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public String getSeqFormat() {
		return this.seqFormat;
	}

	public void setSeqFormat(String seqFormat) {
		this.seqFormat = seqFormat;
	}

	public String getSeqSource() {
		return this.seqSource;
	}

	public void setSeqSource(String seqSource) {
		this.seqSource = seqSource;
	}

	public String getSpecimenId() {
		return this.specimenId;
	}

	public void setSpecimenId(String specimenId) {
		this.specimenId = specimenId;
	}

	public String getStudy() {
		return this.study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	public String getTissueType() {
		return this.tissueType;
	}

	public void setTissueType(String tissueType) {
		this.tissueType = tissueType;
	}

	public String getTssId() {
		return this.tssId;
	}

	public void setTssId(String tssId) {
		this.tssId = tssId;
	}

	public PairTb getPairTb() {
		return this.pairTb;
	}

	public void setPairTb(PairTb pairTb) {
		this.pairTb = pairTb;
	}

}