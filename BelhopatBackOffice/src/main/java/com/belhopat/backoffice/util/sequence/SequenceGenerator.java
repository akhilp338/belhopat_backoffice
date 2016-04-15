package com.belhopat.backoffice.util.sequence;

public class SequenceGenerator {
	
	private static final Long BASE_GENERATOR = 1000L; 

    public static String generateCandidateId( Long increment ) {

        String candidateId = "BHP-C-";
        Long sequence = getSequenceNumber( increment );
        candidateId = candidateId + sequence;
        return candidateId;

    }

    private static Long getSequenceNumber( Long increment ) {
        Long sequence = BASE_GENERATOR + increment;
        return sequence;
    }

}