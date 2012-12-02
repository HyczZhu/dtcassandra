package hycz.cassandra.test.net;

public enum TestVerb {
	MUTATION,
    BINARY,
    READ_REPAIR,
    READ,
    REQUEST_RESPONSE, // client-initiated reads and writes
    STREAM_INITIATE, // Deprecated
    STREAM_INITIATE_DONE, // Deprecated
    STREAM_REPLY,
    STREAM_REQUEST,
    RANGE_SLICE,
    BOOTSTRAP_TOKEN,
    TREE_REQUEST,
    TREE_RESPONSE,
    JOIN, // Deprecated
    GOSSIP_DIGEST_SYN,
    GOSSIP_DIGEST_ACK,
    GOSSIP_DIGEST_ACK2,
    DEFINITIONS_ANNOUNCE,
    DEFINITIONS_UPDATE_RESPONSE,
    TRUNCATE,
    SCHEMA_CHECK,
    INDEX_SCAN,
    REPLICATION_FINISHED,
    INTERNAL_RESPONSE, // responses to internal calls
    COUNTER_MUTATION,
    // use as padding for backwards compatability where a previous version needs to validate a verb from the future.
    UNUSED_1,
    UNUSED_2,
    UNUSED_3,
    Test,
    ;
	// remember to add new verbs at the end, since we serialize by ordinal
}
