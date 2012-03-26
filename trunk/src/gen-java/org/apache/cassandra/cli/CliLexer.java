// $ANTLR 3.2 Sep 23, 2009 12:02:23 E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g 2012-02-13 16:08:01

package org.apache.cassandra.cli;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CliLexer extends Lexer {
    public static final int NODE_THRIFT_GET_WITH_CONDITIONS=15;
    public static final int TTL=74;
    public static final int NODE_SHOW_KEYSPACES=13;
    public static final int CONDITION=37;
    public static final int COUNT=65;
    public static final int DecimalDigit=94;
    public static final int EOF=-1;
    public static final int Identifier=71;
    public static final int NODE_UPDATE_COLUMN_FAMILY=26;
    public static final int SingleStringCharacter=86;
    public static final int NODE_USE_TABLE=7;
    public static final int NODE_DEL_KEYSPACE=23;
    public static final int CREATE=55;
    public static final int NODE_CONNECT=4;
    public static final int CONNECT=45;
    public static final int INCR=62;
    public static final int SingleEscapeCharacter=91;
    public static final int FAMILY=58;
    public static final int GET=60;
    public static final int NODE_DESCRIBE_TABLE=5;
    public static final int COMMENT=97;
    public static final int SHOW=52;
    public static final int T__99=99;
    public static final int ARRAY=39;
    public static final int T__98=98;
    public static final int NODE_ADD_KEYSPACE=22;
    public static final int EXIT=50;
    public static final int NODE_THRIFT_DEL=18;
    public static final int IntegerNegativeLiteral=77;
    public static final int SEMICOLON=44;
    public static final int KEYSPACES=53;
    public static final int CONDITIONS=38;
    public static final int LIST=66;
    public static final int NODE_LIMIT=42;
    public static final int FILE=81;
    public static final int NODE_DESCRIBE_CLUSTER=6;
    public static final int IP_ADDRESS=79;
    public static final int NODE_NO_OP=10;
    public static final int NODE_THRIFT_SET=16;
    public static final int NODE_ID_LIST=32;
    public static final int WS=96;
    public static final int ASSUME=68;
    public static final int NODE_THRIFT_COUNT=17;
    public static final int DESCRIBE=48;
    public static final int Alnum=85;
    public static final int CharacterEscapeSequence=88;
    public static final int NODE_SHOW_CLUSTER_NAME=11;
    public static final int USE=47;
    public static final int NODE_THRIFT_DECR=20;
    public static final int FUNCTION_CALL=36;
    public static final int EscapeSequence=87;
    public static final int Letter=83;
    public static final int DoubleLiteral=78;
    public static final int HELP=46;
    public static final int HexEscapeSequence=89;
    public static final int NODE_EXIT=8;
    public static final int LIMIT=82;
    public static final int DEL=64;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int NODE_LIST=27;
    public static final int UPDATE=56;
    public static final int NODE_UPDATE_KEYSPACE=25;
    public static final int AND=76;
    public static final int NODE_NEW_CF_ACCESS=33;
    public static final int CONSISTENCYLEVEL=69;
    public static final int HexDigit=95;
    public static final int QUIT=51;
    public static final int NODE_TRUNCATE=28;
    public static final int NODE_SHOW_VERSION=12;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int NODE_NEW_KEYSPACE_ACCESS=34;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int TRUNCATE=67;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int COLUMN=57;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int EscapeCharacter=93;
    public static final int T__112=112;
    public static final int PAIR=41;
    public static final int NODE_CONSISTENCY_LEVEL=30;
    public static final int WITH=73;
    public static final int BY=75;
    public static final int UnicodeEscapeSequence=90;
    public static final int HASH=40;
    public static final int SET=61;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int API_VERSION=54;
    public static final int Digit=84;
    public static final int NODE_ASSUME=29;
    public static final int CONVERT_TO_TYPE=35;
    public static final int NODE_THRIFT_GET=14;
    public static final int KEYSPACE=49;
    public static final int NODE_KEY_RANGE=43;
    public static final int NODE_DEL_COLUMN_FAMILY=24;
    public static final int StringLiteral=72;
    public static final int NODE_HELP=9;
    public static final int IntegerPositiveLiteral=70;
    public static final int CONFIG=80;
    public static final int DROP=59;
    public static final int NonEscapeCharacter=92;
    public static final int DECR=63;
    public static final int NODE_ADD_COLUMN_FAMILY=21;
    public static final int NODE_THRIFT_INCR=19;
    public static final int NODE_COLUMN_ACCESS=31;

        public void reportError(RecognitionException e) 
        {
            StringBuilder errorMessage = new StringBuilder("Syntax error at position " + e.charPositionInLine + ": ");

            if (e instanceof NoViableAltException)
            {
                int index = e.charPositionInLine;
                String error = this.input.substring(index, index);
                String statement = this.input.substring(0, this.input.size() - 1);

                errorMessage.append("unexpected \"" + error + "\" for `" + statement + "`.");
            }
            else
            {
                errorMessage.append(this.getErrorMessage(e, this.getTokenNames()));
            }

            throw new RuntimeException(errorMessage.toString());
        }


    // delegates
    // delegators

    public CliLexer() {;} 
    public CliLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CliLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g"; }

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:28:7: ( '/' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:28:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:29:7: ( 'CLUSTER' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:29:9: 'CLUSTER'
            {
            match("CLUSTER"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:30:8: ( 'CLUSTER NAME' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:30:10: 'CLUSTER NAME'
            {
            match("CLUSTER NAME"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:31:8: ( '?' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:31:10: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:32:8: ( 'AS' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:32:10: 'AS'
            {
            match("AS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:33:8: ( 'WHERE' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:33:10: 'WHERE'
            {
            match("WHERE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:34:8: ( '=' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:34:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:35:8: ( '>' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:35:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:36:8: ( '<' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:36:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:37:8: ( '>=' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:37:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:38:8: ( '<=' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:38:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:39:8: ( '[' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:39:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:40:8: ( ',' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:40:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:41:8: ( ']' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:41:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:42:8: ( '{' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:42:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:43:8: ( '}' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:43:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:44:8: ( ':' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:44:10: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:45:8: ( '(' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:45:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:46:8: ( ')' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:46:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:47:8: ( '.' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:47:10: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "CONFIG"
    public final void mCONFIG() throws RecognitionException {
        try {
            int _type = CONFIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:533:7: ( 'CONFIG' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:533:14: 'CONFIG'
            {
            match("CONFIG"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONFIG"

    // $ANTLR start "CONNECT"
    public final void mCONNECT() throws RecognitionException {
        try {
            int _type = CONNECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:534:8: ( 'CONNECT' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:534:14: 'CONNECT'
            {
            match("CONNECT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONNECT"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:535:6: ( 'COUNT' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:535:14: 'COUNT'
            {
            match("COUNT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COUNT"

    // $ANTLR start "DEL"
    public final void mDEL() throws RecognitionException {
        try {
            int _type = DEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:4: ( 'DEL' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:14: 'DEL'
            {
            match("DEL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEL"

    // $ANTLR start "DESCRIBE"
    public final void mDESCRIBE() throws RecognitionException {
        try {
            int _type = DESCRIBE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:537:9: ( 'DESCRIBE' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:537:14: 'DESCRIBE'
            {
            match("DESCRIBE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DESCRIBE"

    // $ANTLR start "USE"
    public final void mUSE() throws RecognitionException {
        try {
            int _type = USE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:538:4: ( 'USE' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:538:14: 'USE'
            {
            match("USE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "USE"

    // $ANTLR start "GET"
    public final void mGET() throws RecognitionException {
        try {
            int _type = GET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:539:4: ( 'GET' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:539:14: 'GET'
            {
            match("GET"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET"

    // $ANTLR start "HELP"
    public final void mHELP() throws RecognitionException {
        try {
            int _type = HELP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:540:5: ( 'HELP' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:540:14: 'HELP'
            {
            match("HELP"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HELP"

    // $ANTLR start "EXIT"
    public final void mEXIT() throws RecognitionException {
        try {
            int _type = EXIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:541:5: ( 'EXIT' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:541:14: 'EXIT'
            {
            match("EXIT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXIT"

    // $ANTLR start "FILE"
    public final void mFILE() throws RecognitionException {
        try {
            int _type = FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:542:5: ( 'FILE' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:542:14: 'FILE'
            {
            match("FILE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FILE"

    // $ANTLR start "QUIT"
    public final void mQUIT() throws RecognitionException {
        try {
            int _type = QUIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:543:5: ( 'QUIT' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:543:14: 'QUIT'
            {
            match("QUIT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUIT"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:544:4: ( 'SET' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:544:14: 'SET'
            {
            match("SET"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "INCR"
    public final void mINCR() throws RecognitionException {
        try {
            int _type = INCR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:545:5: ( 'INCR' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:545:14: 'INCR'
            {
            match("INCR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCR"

    // $ANTLR start "DECR"
    public final void mDECR() throws RecognitionException {
        try {
            int _type = DECR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:546:5: ( 'DECR' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:546:14: 'DECR'
            {
            match("DECR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECR"

    // $ANTLR start "SHOW"
    public final void mSHOW() throws RecognitionException {
        try {
            int _type = SHOW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:547:5: ( 'SHOW' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:547:14: 'SHOW'
            {
            match("SHOW"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHOW"

    // $ANTLR start "KEYSPACE"
    public final void mKEYSPACE() throws RecognitionException {
        try {
            int _type = KEYSPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:548:9: ( 'KEYSPACE' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:548:14: 'KEYSPACE'
            {
            match("KEYSPACE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYSPACE"

    // $ANTLR start "KEYSPACES"
    public final void mKEYSPACES() throws RecognitionException {
        try {
            int _type = KEYSPACES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:549:10: ( 'KEYSPACES' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:549:14: 'KEYSPACES'
            {
            match("KEYSPACES"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYSPACES"

    // $ANTLR start "API_VERSION"
    public final void mAPI_VERSION() throws RecognitionException {
        try {
            int _type = API_VERSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:550:12: ( 'API VERSION' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:550:14: 'API VERSION'
            {
            match("API VERSION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "API_VERSION"

    // $ANTLR start "CREATE"
    public final void mCREATE() throws RecognitionException {
        try {
            int _type = CREATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:551:7: ( 'CREATE' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:551:14: 'CREATE'
            {
            match("CREATE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CREATE"

    // $ANTLR start "DROP"
    public final void mDROP() throws RecognitionException {
        try {
            int _type = DROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:552:5: ( 'DROP' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:552:14: 'DROP'
            {
            match("DROP"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DROP"

    // $ANTLR start "COLUMN"
    public final void mCOLUMN() throws RecognitionException {
        try {
            int _type = COLUMN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:553:7: ( 'COLUMN' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:553:14: 'COLUMN'
            {
            match("COLUMN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLUMN"

    // $ANTLR start "FAMILY"
    public final void mFAMILY() throws RecognitionException {
        try {
            int _type = FAMILY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:554:7: ( 'FAMILY' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:554:14: 'FAMILY'
            {
            match("FAMILY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FAMILY"

    // $ANTLR start "WITH"
    public final void mWITH() throws RecognitionException {
        try {
            int _type = WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:555:5: ( 'WITH' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:555:14: 'WITH'
            {
            match("WITH"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WITH"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:556:3: ( 'BY' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:556:14: 'BY'
            {
            match("BY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:557:4: ( 'AND' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:557:14: 'AND'
            {
            match("AND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "UPDATE"
    public final void mUPDATE() throws RecognitionException {
        try {
            int _type = UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:558:7: ( 'UPDATE' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:558:14: 'UPDATE'
            {
            match("UPDATE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UPDATE"

    // $ANTLR start "LIST"
    public final void mLIST() throws RecognitionException {
        try {
            int _type = LIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:559:5: ( 'LIST' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:559:14: 'LIST'
            {
            match("LIST"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIST"

    // $ANTLR start "LIMIT"
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:560:6: ( 'LIMIT' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:560:14: 'LIMIT'
            {
            match("LIMIT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIMIT"

    // $ANTLR start "TRUNCATE"
    public final void mTRUNCATE() throws RecognitionException {
        try {
            int _type = TRUNCATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:561:9: ( 'TRUNCATE' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:561:14: 'TRUNCATE'
            {
            match("TRUNCATE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUNCATE"

    // $ANTLR start "ASSUME"
    public final void mASSUME() throws RecognitionException {
        try {
            int _type = ASSUME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:562:7: ( 'ASSUME' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:562:14: 'ASSUME'
            {
            match("ASSUME"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSUME"

    // $ANTLR start "TTL"
    public final void mTTL() throws RecognitionException {
        try {
            int _type = TTL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:563:4: ( 'TTL' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:563:14: 'TTL'
            {
            match("TTL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TTL"

    // $ANTLR start "CONSISTENCYLEVEL"
    public final void mCONSISTENCYLEVEL() throws RecognitionException {
        try {
            int _type = CONSISTENCYLEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:564:17: ( 'CONSISTENCYLEVEL' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:564:21: 'CONSISTENCYLEVEL'
            {
            match("CONSISTENCYLEVEL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONSISTENCYLEVEL"

    // $ANTLR start "IP_ADDRESS"
    public final void mIP_ADDRESS() throws RecognitionException {
        try {
            int _type = IP_ADDRESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:567:5: ( IntegerPositiveLiteral '.' IntegerPositiveLiteral '.' IntegerPositiveLiteral '.' IntegerPositiveLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:567:7: IntegerPositiveLiteral '.' IntegerPositiveLiteral '.' IntegerPositiveLiteral '.' IntegerPositiveLiteral
            {
            mIntegerPositiveLiteral(); 
            match('.'); 
            mIntegerPositiveLiteral(); 
            match('.'); 
            mIntegerPositiveLiteral(); 
            match('.'); 
            mIntegerPositiveLiteral(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IP_ADDRESS"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:573:5: ( 'a' .. 'z' | 'A' .. 'Z' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:579:5: ( '0' .. '9' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:579:7: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "Alnum"
    public final void mAlnum() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:584:5: ( Letter | Digit )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Alnum"

    // $ANTLR start "IntegerPositiveLiteral"
    public final void mIntegerPositiveLiteral() throws RecognitionException {
        try {
            int _type = IntegerPositiveLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:590:4: ( ( Digit )+ )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:590:6: ( Digit )+
            {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:590:6: ( Digit )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:590:6: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IntegerPositiveLiteral"

    // $ANTLR start "IntegerNegativeLiteral"
    public final void mIntegerNegativeLiteral() throws RecognitionException {
        try {
            int _type = IntegerNegativeLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:594:4: ( '-' ( Digit )+ )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:594:6: '-' ( Digit )+
            {
            match('-'); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:594:10: ( Digit )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:594:10: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IntegerNegativeLiteral"

    // $ANTLR start "DoubleLiteral"
    public final void mDoubleLiteral() throws RecognitionException {
        try {
            int _type = DoubleLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:598:4: ( ( Digit )+ '.' ( Digit )+ )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:598:6: ( Digit )+ '.' ( Digit )+
            {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:598:6: ( Digit )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:598:6: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            match('.'); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:598:17: ( Digit )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:598:17: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DoubleLiteral"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:601:5: ( ( Letter | Alnum ) ( Alnum | '_' | '-' )* )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:601:7: ( Letter | Alnum ) ( Alnum | '_' | '-' )*
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:601:24: ( Alnum | '_' | '-' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='-'||(LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:606:5: ( '\\'' ( SingleStringCharacter )* '\\'' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:606:7: '\\'' ( SingleStringCharacter )* '\\''
            {
            match('\''); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:606:12: ( SingleStringCharacter )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:606:12: SingleStringCharacter
            	    {
            	    mSingleStringCharacter(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "SingleStringCharacter"
    public final void mSingleStringCharacter() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:610:2: (~ ( '\\'' | '\\\\' ) | '\\\\' EscapeSequence )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='\\') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:610:4: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:611:4: '\\\\' EscapeSequence
                    {
                    match('\\'); 
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "SingleStringCharacter"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:615:2: ( CharacterEscapeSequence | '0' | HexEscapeSequence | UnicodeEscapeSequence )
            int alt8=4;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='\u0000' && LA8_0<='/')||(LA8_0>=':' && LA8_0<='t')||(LA8_0>='v' && LA8_0<='w')||(LA8_0>='y' && LA8_0<='\uFFFF')) ) {
                alt8=1;
            }
            else if ( (LA8_0=='0') ) {
                alt8=2;
            }
            else if ( (LA8_0=='x') ) {
                alt8=3;
            }
            else if ( (LA8_0=='u') ) {
                alt8=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:615:4: CharacterEscapeSequence
                    {
                    mCharacterEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:616:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:617:4: HexEscapeSequence
                    {
                    mHexEscapeSequence(); 

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:618:4: UnicodeEscapeSequence
                    {
                    mUnicodeEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "CharacterEscapeSequence"
    public final void mCharacterEscapeSequence() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:622:2: ( SingleEscapeCharacter | NonEscapeCharacter )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"'||LA9_0=='\''||LA9_0=='\\'||LA9_0=='b'||LA9_0=='f'||LA9_0=='n'||LA9_0=='r'||LA9_0=='t'||LA9_0=='v') ) {
                alt9=1;
            }
            else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='/')||(LA9_0>=':' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='a')||(LA9_0>='c' && LA9_0<='e')||(LA9_0>='g' && LA9_0<='m')||(LA9_0>='o' && LA9_0<='q')||LA9_0=='s'||LA9_0=='w'||(LA9_0>='y' && LA9_0<='\uFFFF')) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:622:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:623:4: NonEscapeCharacter
                    {
                    mNonEscapeCharacter(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "CharacterEscapeSequence"

    // $ANTLR start "NonEscapeCharacter"
    public final void mNonEscapeCharacter() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:627:2: (~ ( EscapeCharacter ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:627:4: ~ ( EscapeCharacter )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='a')||(input.LA(1)>='c' && input.LA(1)<='e')||(input.LA(1)>='g' && input.LA(1)<='m')||(input.LA(1)>='o' && input.LA(1)<='q')||input.LA(1)=='s'||input.LA(1)=='w'||(input.LA(1)>='y' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NonEscapeCharacter"

    // $ANTLR start "SingleEscapeCharacter"
    public final void mSingleEscapeCharacter() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:631:2: ( '\\'' | '\"' | '\\\\' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SingleEscapeCharacter"

    // $ANTLR start "EscapeCharacter"
    public final void mEscapeCharacter() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:635:2: ( SingleEscapeCharacter | DecimalDigit | 'x' | 'u' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case '\"':
            case '\'':
            case '\\':
            case 'b':
            case 'f':
            case 'n':
            case 'r':
            case 't':
            case 'v':
                {
                alt10=1;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt10=2;
                }
                break;
            case 'x':
                {
                alt10=3;
                }
                break;
            case 'u':
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:635:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:636:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:637:4: 'x'
                    {
                    match('x'); 

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:638:4: 'u'
                    {
                    match('u'); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeCharacter"

    // $ANTLR start "HexEscapeSequence"
    public final void mHexEscapeSequence() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:642:2: ( 'x' HexDigit HexDigit )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:642:4: 'x' HexDigit HexDigit
            {
            match('x'); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "HexEscapeSequence"

    // $ANTLR start "UnicodeEscapeSequence"
    public final void mUnicodeEscapeSequence() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:646:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:646:4: 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscapeSequence"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:650:2: ( DecimalDigit | ( 'a' .. 'f' ) | ( 'A' .. 'F' ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt11=1;
                }
                break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                {
                alt11=2;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:650:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:650:19: ( 'a' .. 'f' )
                    {
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:650:19: ( 'a' .. 'f' )
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:650:20: 'a' .. 'f'
                    {
                    matchRange('a','f'); 

                    }


                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:650:32: ( 'A' .. 'F' )
                    {
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:650:32: ( 'A' .. 'F' )
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:650:33: 'A' .. 'F'
                    {
                    matchRange('A','F'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "DecimalDigit"
    public final void mDecimalDigit() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:654:2: ( ( '0' .. '9' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:654:4: ( '0' .. '9' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DecimalDigit"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:662:5: ( ';' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:662:7: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:666:5: ( ( ' ' | '\\r' | '\\t' | '\\n' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:666:8: ( ' ' | '\\r' | '\\t' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:670:5: ( '--' (~ ( '\\n' | '\\r' ) )* | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='-') ) {
                alt14=1;
            }
            else if ( (LA14_0=='/') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:670:7: '--' (~ ( '\\n' | '\\r' ) )*
                    {
                    match("--"); 

                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:670:12: (~ ( '\\n' | '\\r' ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:670:13: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                     _channel=HIDDEN; 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:671:7: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:671:12: ( options {greedy=false; } : . )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='*') ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1=='/') ) {
                                alt13=2;
                            }
                            else if ( ((LA13_1>='\u0000' && LA13_1<='.')||(LA13_1>='0' && LA13_1<='\uFFFF')) ) {
                                alt13=1;
                            }


                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<=')')||(LA13_0>='+' && LA13_0<='\uFFFF')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:671:39: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match("*/"); 

                     _channel=HIDDEN; 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:8: ( T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | CONFIG | CONNECT | COUNT | DEL | DESCRIBE | USE | GET | HELP | EXIT | FILE | QUIT | SET | INCR | DECR | SHOW | KEYSPACE | KEYSPACES | API_VERSION | CREATE | DROP | COLUMN | FAMILY | WITH | BY | AND | UPDATE | LIST | LIMIT | TRUNCATE | ASSUME | TTL | CONSISTENCYLEVEL | IP_ADDRESS | IntegerPositiveLiteral | IntegerNegativeLiteral | DoubleLiteral | Identifier | StringLiteral | SEMICOLON | WS | COMMENT )
        int alt15=61;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:10: T__98
                {
                mT__98(); 

                }
                break;
            case 2 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:16: T__99
                {
                mT__99(); 

                }
                break;
            case 3 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:22: T__100
                {
                mT__100(); 

                }
                break;
            case 4 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:29: T__101
                {
                mT__101(); 

                }
                break;
            case 5 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:36: T__102
                {
                mT__102(); 

                }
                break;
            case 6 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:43: T__103
                {
                mT__103(); 

                }
                break;
            case 7 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:50: T__104
                {
                mT__104(); 

                }
                break;
            case 8 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:57: T__105
                {
                mT__105(); 

                }
                break;
            case 9 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:64: T__106
                {
                mT__106(); 

                }
                break;
            case 10 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:71: T__107
                {
                mT__107(); 

                }
                break;
            case 11 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:78: T__108
                {
                mT__108(); 

                }
                break;
            case 12 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:85: T__109
                {
                mT__109(); 

                }
                break;
            case 13 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:92: T__110
                {
                mT__110(); 

                }
                break;
            case 14 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:99: T__111
                {
                mT__111(); 

                }
                break;
            case 15 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:106: T__112
                {
                mT__112(); 

                }
                break;
            case 16 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:113: T__113
                {
                mT__113(); 

                }
                break;
            case 17 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:120: T__114
                {
                mT__114(); 

                }
                break;
            case 18 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:127: T__115
                {
                mT__115(); 

                }
                break;
            case 19 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:134: T__116
                {
                mT__116(); 

                }
                break;
            case 20 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:141: T__117
                {
                mT__117(); 

                }
                break;
            case 21 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:148: CONFIG
                {
                mCONFIG(); 

                }
                break;
            case 22 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:155: CONNECT
                {
                mCONNECT(); 

                }
                break;
            case 23 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:163: COUNT
                {
                mCOUNT(); 

                }
                break;
            case 24 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:169: DEL
                {
                mDEL(); 

                }
                break;
            case 25 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:173: DESCRIBE
                {
                mDESCRIBE(); 

                }
                break;
            case 26 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:182: USE
                {
                mUSE(); 

                }
                break;
            case 27 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:186: GET
                {
                mGET(); 

                }
                break;
            case 28 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:190: HELP
                {
                mHELP(); 

                }
                break;
            case 29 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:195: EXIT
                {
                mEXIT(); 

                }
                break;
            case 30 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:200: FILE
                {
                mFILE(); 

                }
                break;
            case 31 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:205: QUIT
                {
                mQUIT(); 

                }
                break;
            case 32 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:210: SET
                {
                mSET(); 

                }
                break;
            case 33 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:214: INCR
                {
                mINCR(); 

                }
                break;
            case 34 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:219: DECR
                {
                mDECR(); 

                }
                break;
            case 35 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:224: SHOW
                {
                mSHOW(); 

                }
                break;
            case 36 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:229: KEYSPACE
                {
                mKEYSPACE(); 

                }
                break;
            case 37 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:238: KEYSPACES
                {
                mKEYSPACES(); 

                }
                break;
            case 38 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:248: API_VERSION
                {
                mAPI_VERSION(); 

                }
                break;
            case 39 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:260: CREATE
                {
                mCREATE(); 

                }
                break;
            case 40 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:267: DROP
                {
                mDROP(); 

                }
                break;
            case 41 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:272: COLUMN
                {
                mCOLUMN(); 

                }
                break;
            case 42 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:279: FAMILY
                {
                mFAMILY(); 

                }
                break;
            case 43 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:286: WITH
                {
                mWITH(); 

                }
                break;
            case 44 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:291: BY
                {
                mBY(); 

                }
                break;
            case 45 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:294: AND
                {
                mAND(); 

                }
                break;
            case 46 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:298: UPDATE
                {
                mUPDATE(); 

                }
                break;
            case 47 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:305: LIST
                {
                mLIST(); 

                }
                break;
            case 48 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:310: LIMIT
                {
                mLIMIT(); 

                }
                break;
            case 49 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:316: TRUNCATE
                {
                mTRUNCATE(); 

                }
                break;
            case 50 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:325: ASSUME
                {
                mASSUME(); 

                }
                break;
            case 51 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:332: TTL
                {
                mTTL(); 

                }
                break;
            case 52 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:336: CONSISTENCYLEVEL
                {
                mCONSISTENCYLEVEL(); 

                }
                break;
            case 53 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:353: IP_ADDRESS
                {
                mIP_ADDRESS(); 

                }
                break;
            case 54 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:364: IntegerPositiveLiteral
                {
                mIntegerPositiveLiteral(); 

                }
                break;
            case 55 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:387: IntegerNegativeLiteral
                {
                mIntegerNegativeLiteral(); 

                }
                break;
            case 56 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:410: DoubleLiteral
                {
                mDoubleLiteral(); 

                }
                break;
            case 57 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:424: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 58 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:435: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 59 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:449: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 60 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:459: WS
                {
                mWS(); 

                }
                break;
            case 61 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:1:462: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\1\46\1\41\1\uffff\2\41\1\uffff\1\60\1\62\11\uffff\15\41"+
        "\1\105\7\uffff\3\41\1\117\4\41\4\uffff\16\41\1\144\3\41\2\uffff"+
        "\1\105\1\uffff\6\41\1\uffff\1\41\1\163\2\41\1\166\3\41\1\172\1\41"+
        "\1\174\5\41\1\u0082\3\41\1\uffff\3\41\1\u0089\1\u008a\10\41\2\uffff"+
        "\1\41\1\u0095\1\uffff\1\41\1\u0097\1\u0098\1\uffff\1\41\1\uffff"+
        "\1\u009a\1\u009b\1\u009c\1\41\1\u009e\1\uffff\1\u009f\1\u00a0\1"+
        "\41\1\u00a2\2\41\3\uffff\4\41\1\u00a9\3\41\1\u00ad\1\uffff\1\41"+
        "\2\uffff\1\41\3\uffff\1\41\3\uffff\1\41\1\uffff\1\u00b2\2\41\1\u00b5"+
        "\2\41\1\uffff\1\u00b8\1\u00b9\1\u00ba\1\uffff\1\41\1\u00bc\1\u00bd"+
        "\1\41\1\uffff\1\41\1\u00c1\1\uffff\1\u00c2\1\41\3\uffff\1\41\2\uffff"+
        "\2\41\3\uffff\1\41\1\u00c8\1\u00ca\1\u00cb\1\41\1\uffff\1\u00cd"+
        "\2\uffff\1\41\1\uffff\5\41\1\u00d4\1\uffff";
    static final String DFA15_eofS =
        "\u00d5\uffff";
    static final String DFA15_minS =
        "\1\11\1\52\1\114\1\uffff\1\116\1\110\1\uffff\2\75\11\uffff\1\105"+
        "\1\120\2\105\1\130\1\101\1\125\1\105\1\116\1\105\1\131\1\111\1\122"+
        "\2\55\6\uffff\1\125\1\114\1\105\1\55\1\111\1\104\1\105\1\124\4\uffff"+
        "\1\103\1\117\1\105\1\104\1\124\1\114\1\111\1\114\1\115\1\111\1\124"+
        "\1\117\1\103\1\131\1\55\1\115\1\125\1\114\1\uffff\1\60\1\55\1\uffff"+
        "\1\123\1\106\1\116\1\125\1\101\1\125\1\uffff\1\40\1\55\1\122\1\110"+
        "\1\55\1\103\1\122\1\120\1\55\1\101\1\55\1\120\1\124\1\105\1\111"+
        "\1\124\1\55\1\127\1\122\1\123\1\uffff\1\124\1\111\1\116\1\55\1\56"+
        "\1\124\1\111\1\105\1\111\1\124\1\115\1\124\1\115\2\uffff\1\105\1"+
        "\55\1\uffff\1\122\2\55\1\uffff\1\124\1\uffff\3\55\1\114\1\55\1\uffff"+
        "\2\55\1\120\1\55\1\124\1\103\3\uffff\1\105\1\107\1\103\1\123\1\55"+
        "\1\116\2\105\1\55\1\uffff\1\111\2\uffff\1\105\3\uffff\1\131\3\uffff"+
        "\1\101\1\uffff\1\55\1\101\1\122\1\55\2\124\1\uffff\3\55\1\uffff"+
        "\1\102\2\55\1\103\1\uffff\1\124\1\40\1\uffff\1\55\1\105\3\uffff"+
        "\1\105\2\uffff\2\105\3\uffff\1\116\3\55\1\103\1\uffff\1\55\2\uffff"+
        "\1\131\1\uffff\1\114\1\105\1\126\1\105\1\114\1\55\1\uffff";
    static final String DFA15_maxS =
        "\1\175\1\52\1\122\1\uffff\1\123\1\111\1\uffff\2\75\11\uffff\1\122"+
        "\1\123\2\105\1\130\1\111\1\125\1\110\1\116\1\105\1\131\1\111\1\124"+
        "\1\172\1\71\6\uffff\2\125\1\105\1\172\1\111\1\104\1\105\1\124\4"+
        "\uffff\1\123\1\117\1\105\1\104\1\124\1\114\1\111\1\114\1\115\1\111"+
        "\1\124\1\117\1\103\1\131\1\172\1\123\1\125\1\114\1\uffff\1\71\1"+
        "\172\1\uffff\2\123\1\116\1\125\1\101\1\125\1\uffff\1\40\1\172\1"+
        "\122\1\110\1\172\1\103\1\122\1\120\1\172\1\101\1\172\1\120\1\124"+
        "\1\105\1\111\1\124\1\172\1\127\1\122\1\123\1\uffff\1\124\1\111\1"+
        "\116\1\172\1\71\1\124\1\111\1\105\1\111\1\124\1\115\1\124\1\115"+
        "\2\uffff\1\105\1\172\1\uffff\1\122\2\172\1\uffff\1\124\1\uffff\3"+
        "\172\1\114\1\172\1\uffff\2\172\1\120\1\172\1\124\1\103\3\uffff\1"+
        "\105\1\107\1\103\1\123\1\172\1\116\2\105\1\172\1\uffff\1\111\2\uffff"+
        "\1\105\3\uffff\1\131\3\uffff\1\101\1\uffff\1\172\1\101\1\122\1\172"+
        "\2\124\1\uffff\3\172\1\uffff\1\102\2\172\1\103\1\uffff\1\124\1\172"+
        "\1\uffff\1\172\1\105\3\uffff\1\105\2\uffff\2\105\3\uffff\1\116\3"+
        "\172\1\103\1\uffff\1\172\2\uffff\1\131\1\uffff\1\114\1\105\1\126"+
        "\1\105\1\114\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\3\uffff\1\4\2\uffff\1\7\2\uffff\1\14\1\15\1\16\1\17\1\20\1\21"+
        "\1\22\1\23\1\24\17\uffff\1\71\1\72\1\73\1\74\1\75\1\1\10\uffff\1"+
        "\12\1\10\1\13\1\11\22\uffff\1\66\2\uffff\1\67\6\uffff\1\5\24\uffff"+
        "\1\54\15\uffff\1\46\1\55\2\uffff\1\30\3\uffff\1\32\1\uffff\1\33"+
        "\5\uffff\1\40\6\uffff\1\63\1\70\1\65\11\uffff\1\53\1\uffff\1\42"+
        "\1\50\1\uffff\1\34\1\35\1\36\1\uffff\1\37\1\43\1\41\1\uffff\1\57"+
        "\6\uffff\1\27\3\uffff\1\6\4\uffff\1\60\2\uffff\1\25\2\uffff\1\51"+
        "\1\47\1\62\1\uffff\1\56\1\52\2\uffff\1\3\1\2\1\26\5\uffff\1\31\1"+
        "\uffff\1\44\1\61\1\uffff\1\45\6\uffff\1\64";
    static final String DFA15_specialS =
        "\u00d5\uffff}>";
    static final String[] DFA15_transitionS = {
            "\2\44\2\uffff\1\44\22\uffff\1\44\6\uffff\1\42\1\17\1\20\2\uffff"+
            "\1\12\1\40\1\21\1\1\12\37\1\16\1\43\1\10\1\6\1\7\1\3\1\uffff"+
            "\1\4\1\34\1\2\1\22\1\26\1\27\1\24\1\25\1\32\1\41\1\33\1\35\4"+
            "\41\1\30\1\41\1\31\1\36\1\23\1\41\1\5\3\41\1\11\1\uffff\1\13"+
            "\3\uffff\32\41\1\14\1\uffff\1\15",
            "\1\45",
            "\1\47\2\uffff\1\50\2\uffff\1\51",
            "",
            "\1\54\1\uffff\1\53\2\uffff\1\52",
            "\1\55\1\56",
            "",
            "\1\57",
            "\1\61",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\63\14\uffff\1\64",
            "\1\66\2\uffff\1\65",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\73\7\uffff\1\72",
            "\1\74",
            "\1\75\2\uffff\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103\1\uffff\1\104",
            "\1\41\1\106\1\uffff\12\107\7\uffff\32\41\4\uffff\1\41\1\uffff"+
            "\32\41",
            "\1\45\2\uffff\12\110",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\111",
            "\1\114\1\uffff\1\112\6\uffff\1\113",
            "\1\115",
            "\1\41\2\uffff\12\41\7\uffff\22\41\1\116\7\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "",
            "",
            "",
            "",
            "\1\126\10\uffff\1\124\6\uffff\1\125",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\146\5\uffff\1\145",
            "\1\147",
            "\1\150",
            "",
            "\12\151",
            "\1\41\1\106\1\uffff\12\107\7\uffff\32\41\4\uffff\1\41\1\uffff"+
            "\32\41",
            "",
            "\1\152",
            "\1\153\7\uffff\1\154\4\uffff\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "",
            "\1\162",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\164",
            "\1\165",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\173",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u008b\1\uffff\12\151",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "",
            "",
            "\1\u0094",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "",
            "\1\u0096",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "",
            "\1\u0099",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u009d",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u00a1",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "",
            "\1\u00ae",
            "",
            "",
            "\1\u00af",
            "",
            "",
            "",
            "\1\u00b0",
            "",
            "",
            "",
            "\1\u00b1",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u00b3",
            "\1\u00b4",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u00b6",
            "\1\u00b7",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "",
            "\1\u00bb",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u00be",
            "",
            "\1\u00bf",
            "\1\u00c0\14\uffff\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff"+
            "\1\41\1\uffff\32\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u00c3",
            "",
            "",
            "",
            "\1\u00c4",
            "",
            "",
            "\1\u00c5",
            "\1\u00c6",
            "",
            "",
            "",
            "\1\u00c7",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\41\2\uffff\12\41\7\uffff\22\41\1\u00c9\7\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\u00cc",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "",
            "",
            "\1\u00ce",
            "",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | CONFIG | CONNECT | COUNT | DEL | DESCRIBE | USE | GET | HELP | EXIT | FILE | QUIT | SET | INCR | DECR | SHOW | KEYSPACE | KEYSPACES | API_VERSION | CREATE | DROP | COLUMN | FAMILY | WITH | BY | AND | UPDATE | LIST | LIMIT | TRUNCATE | ASSUME | TTL | CONSISTENCYLEVEL | IP_ADDRESS | IntegerPositiveLiteral | IntegerNegativeLiteral | DoubleLiteral | Identifier | StringLiteral | SEMICOLON | WS | COMMENT );";
        }
    }
 

}