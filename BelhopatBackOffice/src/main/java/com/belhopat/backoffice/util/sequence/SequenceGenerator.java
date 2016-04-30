package com.belhopat.backoffice.util.sequence;

/**
 * @author BHP_DEV
 * Generates sequence
 *
 */
public class SequenceGenerator {
	
	private static final Long BASE_GENERATOR = 1000L; 

	/**
	 * @author BHP_DEV
	 * Generates sequence for candidates
	 *
	 */
    public static String generateCandidateId( Long increment ) {

        String candidateId = "BHP-C-";
        Long sequence = getSequenceNumber( increment );
        candidateId = candidateId + sequence;
        return candidateId;

    }
    /**
     * @author BHP_DEV
     * Generates sequence for employee
     *
     */
    public static String generateEmployeeId( Long increment ) {

        String candidateId = "BHP-E-";
        Long sequence = getSequenceNumber( increment );
        candidateId = candidateId + sequence;
        return candidateId;

    }
    /**
     * @author BHP_DEV
     * Base sequence generator
     *
     */
    private static Long getSequenceNumber( Long increment ) {
        Long sequence = BASE_GENERATOR + increment;
        return sequence;
    }

}