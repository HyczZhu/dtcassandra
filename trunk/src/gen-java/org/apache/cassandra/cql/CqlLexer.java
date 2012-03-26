// $ANTLR 3.2 Sep 23, 2009 12:02:23 E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g 2012-02-13 16:08:03

    package org.apache.cassandra.cql;
    import org.apache.cassandra.thrift.InvalidRequestException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CqlLexer extends Lexer {
    public static final int LETTER=70;
    public static final int K_CREATE=31;
    public static final int EOF=-1;
    public static final int K_PRIMARY=36;
    public static final int T__91=91;
    public static final int K_VALUES=23;
    public static final int K_USE=4;
    public static final int T__92=92;
    public static final int STRING_LITERAL=9;
    public static final int T__90=90;
    public static final int K_ON=39;
    public static final int K_USING=11;
    public static final int K_KEY=22;
    public static final int K_TRUNCATE=42;
    public static final int COMMENT=73;
    public static final int D=56;
    public static final int E=44;
    public static final int F=48;
    public static final int G=62;
    public static final int K_KEYSPACE=32;
    public static final int T__80=80;
    public static final int K_COUNT=7;
    public static final int A=54;
    public static final int T__81=81;
    public static final int B=65;
    public static final int T__82=82;
    public static final int C=46;
    public static final int T__83=83;
    public static final int L=45;
    public static final int M=51;
    public static final int N=55;
    public static final int O=50;
    public static final int H=53;
    public static final int I=59;
    public static final int J=67;
    public static final int K_UPDATE=27;
    public static final int K=57;
    public static final int U=60;
    public static final int T=47;
    public static final int W=52;
    public static final int V=64;
    public static final int Q=63;
    public static final int P=61;
    public static final int S=43;
    public static final int R=49;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int Y=58;
    public static final int T__88=88;
    public static final int X=66;
    public static final int Z=68;
    public static final int K_INDEX=38;
    public static final int K_REVERSED=17;
    public static final int K_INSERT=20;
    public static final int WS=72;
    public static final int K_APPLY=26;
    public static final int K_AND=19;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int K_LEVEL=13;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int K_BATCH=25;
    public static final int T__77=77;
    public static final int UUID=41;
    public static final int K_DELETE=29;
    public static final int FLOAT=37;
    public static final int K_SELECT=6;
    public static final int K_LIMIT=15;
    public static final int K_SET=28;
    public static final int K_WHERE=14;
    public static final int MULTILINE_COMMENT=74;
    public static final int K_INTO=21;
    public static final int HEX=71;
    public static final int IDENT=5;
    public static final int DIGIT=69;
    public static final int K_FIRST=16;
    public static final int K_BEGIN=24;
    public static final int INTEGER=10;
    public static final int RANGEOP=18;
    public static final int K_CONSISTENCY=12;
    public static final int K_WITH=33;
    public static final int COMPIDENT=34;
    public static final int K_IN=30;
    public static final int K_FROM=8;
    public static final int K_COLUMNFAMILY=35;
    public static final int K_DROP=40;

        List<Token> tokens = new ArrayList<Token>();
        
        public void emit(Token token) {
            state.token = token;
            tokens.add(token);
        }
        
        public Token nextToken() {
            super.nextToken();
            if (tokens.size() == 0)
                return Token.EOF_TOKEN;
            return tokens.remove(0);
        }
        
        private List<String> recognitionErrors = new ArrayList<String>();
        
        public void displayRecognitionError(String[] tokenNames, RecognitionException e)
        {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            recognitionErrors.add(hdr + " " + msg);
        }
        
        public List<String> getRecognitionErrors()
        {
            return recognitionErrors;
        }
        
        public void throwLastRecognitionError() throws InvalidRequestException
        {
            if (recognitionErrors.size() > 0)
                throw new InvalidRequestException(recognitionErrors.get((recognitionErrors.size()-1)));
        }


    // delegates
    // delegators

    public CqlLexer() {;} 
    public CqlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CqlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g"; }

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:47:7: ( '(' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:47:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:48:7: ( ')' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:48:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:49:7: ( ',' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:49:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:50:7: ( '\\*' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:50:9: '\\*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:51:7: ( ';' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:51:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:52:7: ( '=' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:52:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:53:7: ( 'bytea' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:53:9: 'bytea'
            {
            match("bytea"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:54:7: ( 'ascii' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:54:9: 'ascii'
            {
            match("ascii"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:55:7: ( 'text' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:55:9: 'text'
            {
            match("text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:56:7: ( 'varchar' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:56:9: 'varchar'
            {
            match("varchar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:57:7: ( 'int' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:57:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:58:7: ( 'varint' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:58:9: 'varint'
            {
            match("varint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:59:7: ( 'bigint' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:59:9: 'bigint'
            {
            match("bigint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:60:7: ( 'uuid' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:60:9: 'uuid'
            {
            match("uuid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:61:7: ( '<' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:61:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:62:7: ( '<=' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:62:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:63:7: ( '>=' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:63:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:64:7: ( '>' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:64:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "K_SELECT"
    public final void mK_SELECT() throws RecognitionException {
        try {
            int _type = K_SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:380:9: ( S E L E C T )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:380:16: S E L E C T
            {
            mS(); 
            mE(); 
            mL(); 
            mE(); 
            mC(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_SELECT"

    // $ANTLR start "K_FROM"
    public final void mK_FROM() throws RecognitionException {
        try {
            int _type = K_FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:381:7: ( F R O M )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:381:16: F R O M
            {
            mF(); 
            mR(); 
            mO(); 
            mM(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_FROM"

    // $ANTLR start "K_WHERE"
    public final void mK_WHERE() throws RecognitionException {
        try {
            int _type = K_WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:382:8: ( W H E R E )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:382:16: W H E R E
            {
            mW(); 
            mH(); 
            mE(); 
            mR(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_WHERE"

    // $ANTLR start "K_AND"
    public final void mK_AND() throws RecognitionException {
        try {
            int _type = K_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:383:6: ( A N D )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:383:16: A N D
            {
            mA(); 
            mN(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_AND"

    // $ANTLR start "K_KEY"
    public final void mK_KEY() throws RecognitionException {
        try {
            int _type = K_KEY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:384:6: ( K E Y )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:384:16: K E Y
            {
            mK(); 
            mE(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_KEY"

    // $ANTLR start "K_INSERT"
    public final void mK_INSERT() throws RecognitionException {
        try {
            int _type = K_INSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:385:9: ( I N S E R T )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:385:16: I N S E R T
            {
            mI(); 
            mN(); 
            mS(); 
            mE(); 
            mR(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INSERT"

    // $ANTLR start "K_UPDATE"
    public final void mK_UPDATE() throws RecognitionException {
        try {
            int _type = K_UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:386:9: ( U P D A T E )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:386:16: U P D A T E
            {
            mU(); 
            mP(); 
            mD(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_UPDATE"

    // $ANTLR start "K_WITH"
    public final void mK_WITH() throws RecognitionException {
        try {
            int _type = K_WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:387:7: ( W I T H )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:387:16: W I T H
            {
            mW(); 
            mI(); 
            mT(); 
            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_WITH"

    // $ANTLR start "K_LIMIT"
    public final void mK_LIMIT() throws RecognitionException {
        try {
            int _type = K_LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:388:8: ( L I M I T )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:388:16: L I M I T
            {
            mL(); 
            mI(); 
            mM(); 
            mI(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_LIMIT"

    // $ANTLR start "K_USING"
    public final void mK_USING() throws RecognitionException {
        try {
            int _type = K_USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:389:8: ( U S I N G )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:389:16: U S I N G
            {
            mU(); 
            mS(); 
            mI(); 
            mN(); 
            mG(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_USING"

    // $ANTLR start "K_CONSISTENCY"
    public final void mK_CONSISTENCY() throws RecognitionException {
        try {
            int _type = K_CONSISTENCY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:390:14: ( C O N S I S T E N C Y )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:390:16: C O N S I S T E N C Y
            {
            mC(); 
            mO(); 
            mN(); 
            mS(); 
            mI(); 
            mS(); 
            mT(); 
            mE(); 
            mN(); 
            mC(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_CONSISTENCY"

    // $ANTLR start "K_LEVEL"
    public final void mK_LEVEL() throws RecognitionException {
        try {
            int _type = K_LEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:391:8: ( ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:391:16: ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M )
            {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:391:16: ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 'O':
            case 'o':
                {
                alt1=1;
                }
                break;
            case 'Q':
            case 'q':
                {
                alt1=2;
                }
                break;
            case 'A':
            case 'a':
                {
                int LA1_3 = input.LA(2);

                if ( (LA1_3=='L'||LA1_3=='l') ) {
                    alt1=3;
                }
                else if ( (LA1_3=='N'||LA1_3=='n') ) {
                    alt1=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
                }
                break;
            case 'L':
            case 'l':
                {
                alt1=5;
                }
                break;
            case 'E':
            case 'e':
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:391:18: O N E
                    {
                    mO(); 
                    mN(); 
                    mE(); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:392:18: Q U O R U M
                    {
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:393:18: A L L
                    {
                    mA(); 
                    mL(); 
                    mL(); 

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:394:18: A N Y
                    {
                    mA(); 
                    mN(); 
                    mY(); 

                    }
                    break;
                case 5 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:395:18: L O C A L '_' Q U O R U M
                    {
                    mL(); 
                    mO(); 
                    mC(); 
                    mA(); 
                    mL(); 
                    match('_'); 
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;
                case 6 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:396:18: E A C H '_' Q U O R U M
                    {
                    mE(); 
                    mA(); 
                    mC(); 
                    mH(); 
                    match('_'); 
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_LEVEL"

    // $ANTLR start "K_USE"
    public final void mK_USE() throws RecognitionException {
        try {
            int _type = K_USE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:399:6: ( U S E )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:399:16: U S E
            {
            mU(); 
            mS(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_USE"

    // $ANTLR start "K_FIRST"
    public final void mK_FIRST() throws RecognitionException {
        try {
            int _type = K_FIRST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:400:8: ( F I R S T )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:400:16: F I R S T
            {
            mF(); 
            mI(); 
            mR(); 
            mS(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_FIRST"

    // $ANTLR start "K_REVERSED"
    public final void mK_REVERSED() throws RecognitionException {
        try {
            int _type = K_REVERSED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:401:11: ( R E V E R S E D )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:401:16: R E V E R S E D
            {
            mR(); 
            mE(); 
            mV(); 
            mE(); 
            mR(); 
            mS(); 
            mE(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_REVERSED"

    // $ANTLR start "K_COUNT"
    public final void mK_COUNT() throws RecognitionException {
        try {
            int _type = K_COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:402:8: ( C O U N T )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:402:16: C O U N T
            {
            mC(); 
            mO(); 
            mU(); 
            mN(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_COUNT"

    // $ANTLR start "K_SET"
    public final void mK_SET() throws RecognitionException {
        try {
            int _type = K_SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:403:6: ( S E T )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:403:16: S E T
            {
            mS(); 
            mE(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_SET"

    // $ANTLR start "K_BEGIN"
    public final void mK_BEGIN() throws RecognitionException {
        try {
            int _type = K_BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:404:8: ( B E G I N )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:404:16: B E G I N
            {
            mB(); 
            mE(); 
            mG(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BEGIN"

    // $ANTLR start "K_APPLY"
    public final void mK_APPLY() throws RecognitionException {
        try {
            int _type = K_APPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:405:8: ( A P P L Y )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:405:16: A P P L Y
            {
            mA(); 
            mP(); 
            mP(); 
            mL(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_APPLY"

    // $ANTLR start "K_BATCH"
    public final void mK_BATCH() throws RecognitionException {
        try {
            int _type = K_BATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:406:8: ( B A T C H )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:406:16: B A T C H
            {
            mB(); 
            mA(); 
            mT(); 
            mC(); 
            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BATCH"

    // $ANTLR start "K_TRUNCATE"
    public final void mK_TRUNCATE() throws RecognitionException {
        try {
            int _type = K_TRUNCATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:407:11: ( T R U N C A T E )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:407:16: T R U N C A T E
            {
            mT(); 
            mR(); 
            mU(); 
            mN(); 
            mC(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TRUNCATE"

    // $ANTLR start "K_DELETE"
    public final void mK_DELETE() throws RecognitionException {
        try {
            int _type = K_DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:408:9: ( D E L E T E )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:408:16: D E L E T E
            {
            mD(); 
            mE(); 
            mL(); 
            mE(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DELETE"

    // $ANTLR start "K_IN"
    public final void mK_IN() throws RecognitionException {
        try {
            int _type = K_IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:409:5: ( I N )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:409:16: I N
            {
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_IN"

    // $ANTLR start "K_CREATE"
    public final void mK_CREATE() throws RecognitionException {
        try {
            int _type = K_CREATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:410:9: ( C R E A T E )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:410:16: C R E A T E
            {
            mC(); 
            mR(); 
            mE(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_CREATE"

    // $ANTLR start "K_KEYSPACE"
    public final void mK_KEYSPACE() throws RecognitionException {
        try {
            int _type = K_KEYSPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:411:11: ( K E Y S P A C E )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:411:16: K E Y S P A C E
            {
            mK(); 
            mE(); 
            mY(); 
            mS(); 
            mP(); 
            mA(); 
            mC(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_KEYSPACE"

    // $ANTLR start "K_COLUMNFAMILY"
    public final void mK_COLUMNFAMILY() throws RecognitionException {
        try {
            int _type = K_COLUMNFAMILY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:412:15: ( C O L U M N F A M I L Y )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:412:17: C O L U M N F A M I L Y
            {
            mC(); 
            mO(); 
            mL(); 
            mU(); 
            mM(); 
            mN(); 
            mF(); 
            mA(); 
            mM(); 
            mI(); 
            mL(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_COLUMNFAMILY"

    // $ANTLR start "K_INDEX"
    public final void mK_INDEX() throws RecognitionException {
        try {
            int _type = K_INDEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:413:8: ( I N D E X )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:413:16: I N D E X
            {
            mI(); 
            mN(); 
            mD(); 
            mE(); 
            mX(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INDEX"

    // $ANTLR start "K_ON"
    public final void mK_ON() throws RecognitionException {
        try {
            int _type = K_ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:414:5: ( O N )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:414:16: O N
            {
            mO(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ON"

    // $ANTLR start "K_DROP"
    public final void mK_DROP() throws RecognitionException {
        try {
            int _type = K_DROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:415:7: ( D R O P )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:415:16: D R O P
            {
            mD(); 
            mR(); 
            mO(); 
            mP(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DROP"

    // $ANTLR start "K_PRIMARY"
    public final void mK_PRIMARY() throws RecognitionException {
        try {
            int _type = K_PRIMARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:416:10: ( P R I M A R Y )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:416:16: P R I M A R Y
            {
            mP(); 
            mR(); 
            mI(); 
            mM(); 
            mA(); 
            mR(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_PRIMARY"

    // $ANTLR start "K_INTO"
    public final void mK_INTO() throws RecognitionException {
        try {
            int _type = K_INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:417:7: ( I N T O )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:417:16: I N T O
            {
            mI(); 
            mN(); 
            mT(); 
            mO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INTO"

    // $ANTLR start "K_VALUES"
    public final void mK_VALUES() throws RecognitionException {
        try {
            int _type = K_VALUES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:418:9: ( V A L U E S )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:418:16: V A L U E S
            {
            mV(); 
            mA(); 
            mL(); 
            mU(); 
            mE(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_VALUES"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:421:11: ( ( 'a' | 'A' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:421:13: ( 'a' | 'A' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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
    // $ANTLR end "A"

    // $ANTLR start "B"
    public final void mB() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:422:11: ( ( 'b' | 'B' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:422:13: ( 'b' | 'B' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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
    // $ANTLR end "B"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:423:11: ( ( 'c' | 'C' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:423:13: ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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
    // $ANTLR end "C"

    // $ANTLR start "D"
    public final void mD() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:424:11: ( ( 'd' | 'D' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:424:13: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "D"

    // $ANTLR start "E"
    public final void mE() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:425:11: ( ( 'e' | 'E' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:425:13: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "E"

    // $ANTLR start "F"
    public final void mF() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:426:11: ( ( 'f' | 'F' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:426:13: ( 'f' | 'F' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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
    // $ANTLR end "F"

    // $ANTLR start "G"
    public final void mG() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:427:11: ( ( 'g' | 'G' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:427:13: ( 'g' | 'G' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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
    // $ANTLR end "G"

    // $ANTLR start "H"
    public final void mH() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:428:11: ( ( 'h' | 'H' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:428:13: ( 'h' | 'H' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "H"

    // $ANTLR start "I"
    public final void mI() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:429:11: ( ( 'i' | 'I' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:429:13: ( 'i' | 'I' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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
    // $ANTLR end "I"

    // $ANTLR start "J"
    public final void mJ() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:430:11: ( ( 'j' | 'J' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:430:13: ( 'j' | 'J' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
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
    // $ANTLR end "J"

    // $ANTLR start "K"
    public final void mK() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:431:11: ( ( 'k' | 'K' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:431:13: ( 'k' | 'K' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
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
    // $ANTLR end "K"

    // $ANTLR start "L"
    public final void mL() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:432:11: ( ( 'l' | 'L' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:432:13: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end "L"

    // $ANTLR start "M"
    public final void mM() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:433:11: ( ( 'm' | 'M' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:433:13: ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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
    // $ANTLR end "M"

    // $ANTLR start "N"
    public final void mN() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:434:11: ( ( 'n' | 'N' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:434:13: ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "N"

    // $ANTLR start "O"
    public final void mO() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:435:11: ( ( 'o' | 'O' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:435:13: ( 'o' | 'O' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
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
    // $ANTLR end "O"

    // $ANTLR start "P"
    public final void mP() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:436:11: ( ( 'p' | 'P' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:436:13: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
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
    // $ANTLR end "P"

    // $ANTLR start "Q"
    public final void mQ() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:437:11: ( ( 'q' | 'Q' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:437:13: ( 'q' | 'Q' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
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
    // $ANTLR end "Q"

    // $ANTLR start "R"
    public final void mR() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:438:11: ( ( 'r' | 'R' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:438:13: ( 'r' | 'R' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "R"

    // $ANTLR start "S"
    public final void mS() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:439:11: ( ( 's' | 'S' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:439:13: ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "S"

    // $ANTLR start "T"
    public final void mT() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:440:11: ( ( 't' | 'T' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:440:13: ( 't' | 'T' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "T"

    // $ANTLR start "U"
    public final void mU() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:441:11: ( ( 'u' | 'U' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:441:13: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
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
    // $ANTLR end "U"

    // $ANTLR start "V"
    public final void mV() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:442:11: ( ( 'v' | 'V' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:442:13: ( 'v' | 'V' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
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
    // $ANTLR end "V"

    // $ANTLR start "W"
    public final void mW() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:443:11: ( ( 'w' | 'W' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:443:13: ( 'w' | 'W' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
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
    // $ANTLR end "W"

    // $ANTLR start "X"
    public final void mX() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:444:11: ( ( 'x' | 'X' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:444:13: ( 'x' | 'X' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
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
    // $ANTLR end "X"

    // $ANTLR start "Y"
    public final void mY() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:445:11: ( ( 'y' | 'Y' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:445:13: ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
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
    // $ANTLR end "Y"

    // $ANTLR start "Z"
    public final void mZ() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:446:11: ( ( 'z' | 'Z' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:446:13: ( 'z' | 'Z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
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
    // $ANTLR end "Z"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:449:5: ( '\\'' (c=~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' )* '\\'' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:449:7: '\\'' (c=~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' )* '\\''
            {
            match('\''); 
             StringBuilder b = new StringBuilder(); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:451:7: (c=~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\'') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='\'') ) {
                        alt2=2;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:451:9: c=~ ( '\\'' | '\\r' | '\\n' )
            	    {
            	    c= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	     b.appendCodePoint(c);

            	    }
            	    break;
            	case 2 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:452:9: '\\'' '\\''
            	    {
            	    match('\''); 
            	    match('\''); 
            	     b.appendCodePoint('\'');

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\''); 
             setText(b.toString()); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:459:5: ( '0' .. '9' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:459:7: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:463:5: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:463:7: ( 'A' .. 'Z' | 'a' .. 'z' )
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
    // $ANTLR end "LETTER"

    // $ANTLR start "HEX"
    public final void mHEX() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:467:5: ( ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:467:7: ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end "HEX"

    // $ANTLR start "RANGEOP"
    public final void mRANGEOP() throws RecognitionException {
        try {
            int _type = RANGEOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:471:5: ( '..' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:471:7: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGEOP"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:475:5: ( ( '-' )? ( DIGIT )+ )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:475:7: ( '-' )? ( DIGIT )+
            {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:475:7: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:475:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:475:12: ( DIGIT )+
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
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:475:12: DIGIT
            	    {
            	    mDIGIT(); 

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
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken d=null;
            CommonToken r=null;

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:482:5: (d= INTEGER r= RANGEOP | INTEGER '.' INTEGER )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:482:7: d= INTEGER r= RANGEOP
                    {
                    int dStart1636 = getCharIndex();
                    mINTEGER(); 
                    d = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, dStart1636, getCharIndex()-1);
                    int rStart1640 = getCharIndex();
                    mRANGEOP(); 
                    r = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, rStart1640, getCharIndex()-1);

                              d.setType(INTEGER);
                              emit(d);
                              r.setType(RANGEOP);
                              emit(r);
                          

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:489:9: INTEGER '.' INTEGER
                    {
                    mINTEGER(); 
                    match('.'); 
                    mINTEGER(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:493:5: ( LETTER ( LETTER | DIGIT | '_' )* )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:493:7: LETTER ( LETTER | DIGIT | '_' )*
            {
            mLETTER(); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:493:14: ( LETTER | DIGIT | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "COMPIDENT"
    public final void mCOMPIDENT() throws RecognitionException {
        try {
            int _type = COMPIDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:497:5: ( IDENT ( ':' IDENT )* )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:497:7: IDENT ( ':' IDENT )*
            {
            mIDENT(); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:497:13: ( ':' IDENT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==':') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:497:15: ':' IDENT
            	    {
            	    match(':'); 
            	    mIDENT(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMPIDENT"

    // $ANTLR start "UUID"
    public final void mUUID() throws RecognitionException {
        try {
            int _type = UUID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:501:5: ( HEX HEX HEX HEX HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:501:7: HEX HEX HEX HEX HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX
            {
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UUID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:509:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:509:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:509:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

             _channel = HIDDEN; 

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
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:5: ( ( '--' | '//' ) ( . )* ( '\\n' | '\\r' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:7: ( '--' | '//' ) ( . )* ( '\\n' | '\\r' )
            {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:7: ( '--' | '//' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='-') ) {
                alt9=1;
            }
            else if ( (LA9_0=='/') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:8: '--'
                    {
                    match("--"); 


                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:15: '//'
                    {
                    match("//"); 


                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:21: ( . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                    alt10=2;
                }
                else if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:21: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:517:5: ( '/*' ( . )* '*/' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:517:7: '/*' ( . )* '*/'
            {
            match("/*"); 

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:517:12: ( . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='.')||(LA11_1>='0' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:517:12: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match("*/"); 

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:8: ( T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | K_SELECT | K_FROM | K_WHERE | K_AND | K_KEY | K_INSERT | K_UPDATE | K_WITH | K_LIMIT | K_USING | K_CONSISTENCY | K_LEVEL | K_USE | K_FIRST | K_REVERSED | K_COUNT | K_SET | K_BEGIN | K_APPLY | K_BATCH | K_TRUNCATE | K_DELETE | K_IN | K_CREATE | K_KEYSPACE | K_COLUMNFAMILY | K_INDEX | K_ON | K_DROP | K_PRIMARY | K_INTO | K_VALUES | STRING_LITERAL | RANGEOP | INTEGER | FLOAT | IDENT | COMPIDENT | UUID | WS | COMMENT | MULTILINE_COMMENT )
        int alt12=60;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:10: T__75
                {
                mT__75(); 

                }
                break;
            case 2 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:16: T__76
                {
                mT__76(); 

                }
                break;
            case 3 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:22: T__77
                {
                mT__77(); 

                }
                break;
            case 4 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:28: T__78
                {
                mT__78(); 

                }
                break;
            case 5 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:34: T__79
                {
                mT__79(); 

                }
                break;
            case 6 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:40: T__80
                {
                mT__80(); 

                }
                break;
            case 7 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:46: T__81
                {
                mT__81(); 

                }
                break;
            case 8 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:52: T__82
                {
                mT__82(); 

                }
                break;
            case 9 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:58: T__83
                {
                mT__83(); 

                }
                break;
            case 10 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:64: T__84
                {
                mT__84(); 

                }
                break;
            case 11 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:70: T__85
                {
                mT__85(); 

                }
                break;
            case 12 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:76: T__86
                {
                mT__86(); 

                }
                break;
            case 13 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:82: T__87
                {
                mT__87(); 

                }
                break;
            case 14 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:88: T__88
                {
                mT__88(); 

                }
                break;
            case 15 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:94: T__89
                {
                mT__89(); 

                }
                break;
            case 16 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:100: T__90
                {
                mT__90(); 

                }
                break;
            case 17 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:106: T__91
                {
                mT__91(); 

                }
                break;
            case 18 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:112: T__92
                {
                mT__92(); 

                }
                break;
            case 19 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:118: K_SELECT
                {
                mK_SELECT(); 

                }
                break;
            case 20 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:127: K_FROM
                {
                mK_FROM(); 

                }
                break;
            case 21 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:134: K_WHERE
                {
                mK_WHERE(); 

                }
                break;
            case 22 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:142: K_AND
                {
                mK_AND(); 

                }
                break;
            case 23 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:148: K_KEY
                {
                mK_KEY(); 

                }
                break;
            case 24 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:154: K_INSERT
                {
                mK_INSERT(); 

                }
                break;
            case 25 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:163: K_UPDATE
                {
                mK_UPDATE(); 

                }
                break;
            case 26 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:172: K_WITH
                {
                mK_WITH(); 

                }
                break;
            case 27 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:179: K_LIMIT
                {
                mK_LIMIT(); 

                }
                break;
            case 28 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:187: K_USING
                {
                mK_USING(); 

                }
                break;
            case 29 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:195: K_CONSISTENCY
                {
                mK_CONSISTENCY(); 

                }
                break;
            case 30 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:209: K_LEVEL
                {
                mK_LEVEL(); 

                }
                break;
            case 31 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:217: K_USE
                {
                mK_USE(); 

                }
                break;
            case 32 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:223: K_FIRST
                {
                mK_FIRST(); 

                }
                break;
            case 33 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:231: K_REVERSED
                {
                mK_REVERSED(); 

                }
                break;
            case 34 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:242: K_COUNT
                {
                mK_COUNT(); 

                }
                break;
            case 35 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:250: K_SET
                {
                mK_SET(); 

                }
                break;
            case 36 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:256: K_BEGIN
                {
                mK_BEGIN(); 

                }
                break;
            case 37 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:264: K_APPLY
                {
                mK_APPLY(); 

                }
                break;
            case 38 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:272: K_BATCH
                {
                mK_BATCH(); 

                }
                break;
            case 39 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:280: K_TRUNCATE
                {
                mK_TRUNCATE(); 

                }
                break;
            case 40 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:291: K_DELETE
                {
                mK_DELETE(); 

                }
                break;
            case 41 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:300: K_IN
                {
                mK_IN(); 

                }
                break;
            case 42 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:305: K_CREATE
                {
                mK_CREATE(); 

                }
                break;
            case 43 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:314: K_KEYSPACE
                {
                mK_KEYSPACE(); 

                }
                break;
            case 44 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:325: K_COLUMNFAMILY
                {
                mK_COLUMNFAMILY(); 

                }
                break;
            case 45 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:340: K_INDEX
                {
                mK_INDEX(); 

                }
                break;
            case 46 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:348: K_ON
                {
                mK_ON(); 

                }
                break;
            case 47 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:353: K_DROP
                {
                mK_DROP(); 

                }
                break;
            case 48 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:360: K_PRIMARY
                {
                mK_PRIMARY(); 

                }
                break;
            case 49 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:370: K_INTO
                {
                mK_INTO(); 

                }
                break;
            case 50 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:377: K_VALUES
                {
                mK_VALUES(); 

                }
                break;
            case 51 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:386: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 52 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:401: RANGEOP
                {
                mRANGEOP(); 

                }
                break;
            case 53 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:409: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 54 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:417: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 55 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:423: IDENT
                {
                mIDENT(); 

                }
                break;
            case 56 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:429: COMPIDENT
                {
                mCOMPIDENT(); 

                }
                break;
            case 57 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:439: UUID
                {
                mUUID(); 

                }
                break;
            case 58 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:444: WS
                {
                mWS(); 

                }
                break;
            case 59 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:447: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 60 :
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:455: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA5_eotS =
        "\6\uffff";
    static final String DFA5_eofS =
        "\6\uffff";
    static final String DFA5_minS =
        "\1\55\1\60\1\56\1\55\2\uffff";
    static final String DFA5_maxS =
        "\4\71\2\uffff";
    static final String DFA5_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA5_specialS =
        "\6\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\2\uffff\12\2",
            "\12\2",
            "\1\3\1\uffff\12\2",
            "\1\5\1\4\1\uffff\12\5",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "481:1: FLOAT : (d= INTEGER r= RANGEOP | INTEGER '.' INTEGER );";
        }
    }
    static final String DFA12_eotS =
        "\7\uffff\6\52\1\76\1\100\22\52\3\uffff\1\124\1\52\2\uffff\2\52"+
        "\1\uffff\4\52\1\uffff\10\52\2\150\3\52\4\uffff\12\52\1\175\6\52"+
        "\1\uffff\1\124\1\uffff\1\124\3\uffff\6\52\1\u008c\1\u008d\1\u008c"+
        "\5\52\1\u0094\1\uffff\4\52\1\u0099\3\52\1\u009d\4\52\1\u00a2\6\52"+
        "\1\uffff\1\u008c\6\52\1\124\6\52\2\uffff\1\52\1\u00b8\4\52\1\uffff"+
        "\1\u00bd\2\52\1\u00c0\1\uffff\3\52\1\uffff\1\u00c4\1\52\1\u00c6"+
        "\1\52\1\uffff\13\52\1\u00d3\1\52\1\124\1\u00d6\2\52\1\u00d9\1\u00da"+
        "\1\u00db\1\u00dc\1\uffff\4\52\1\uffff\1\52\1\u00e2\1\uffff\1\u00e3"+
        "\2\52\1\uffff\1\u00e6\1\uffff\1\u00e7\1\52\1\u00e9\1\52\1\u00eb"+
        "\7\52\1\uffff\1\52\1\124\1\uffff\1\u00f5\1\52\4\uffff\2\52\1\u00f9"+
        "\1\u00fa\1\u00fb\2\uffff\1\u00fc\1\u00fd\2\uffff\1\52\1\uffff\1"+
        "\52\1\uffff\2\52\1\u0102\1\u008c\2\52\1\u0105\1\52\1\124\1\uffff"+
        "\2\52\1\u010a\5\uffff\4\52\1\uffff\2\52\1\uffff\1\u0111\1\124\1"+
        "\52\1\u0113\1\uffff\1\u0114\4\52\1\u0119\1\uffff\1\124\2\uffff\4"+
        "\52\1\uffff\5\52\1\u0123\1\52\2\u008c\1\uffff\1\u0125\1\uffff";
    static final String DFA12_eofS =
        "\u0126\uffff";
    static final String DFA12_minS =
        "\1\11\6\uffff\6\60\2\75\22\60\2\uffff\1\55\1\56\1\60\1\uffff\1"+
        "\52\2\60\1\uffff\4\60\1\uffff\15\60\4\uffff\21\60\1\uffff\1\56\1"+
        "\uffff\1\56\3\uffff\17\60\1\uffff\24\60\1\uffff\7\60\1\56\6\60\2"+
        "\uffff\6\60\1\uffff\4\60\1\uffff\3\60\1\uffff\4\60\1\uffff\15\60"+
        "\1\56\7\60\1\uffff\4\60\1\uffff\2\60\1\uffff\3\60\1\uffff\1\60\1"+
        "\uffff\14\60\1\uffff\1\60\1\56\1\uffff\2\60\4\uffff\5\60\2\uffff"+
        "\2\60\2\uffff\1\60\1\uffff\1\60\1\uffff\10\60\1\56\1\uffff\3\60"+
        "\5\uffff\4\60\1\uffff\2\60\1\uffff\1\60\1\56\1\55\1\60\1\uffff\6"+
        "\60\1\uffff\1\55\2\uffff\4\60\1\uffff\11\60\1\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\172\6\uffff\6\172\2\75\22\172\2\uffff\1\71\1\146\1\172\1\uffff"+
        "\1\57\2\172\1\uffff\4\172\1\uffff\15\172\4\uffff\21\172\1\uffff"+
        "\1\71\1\uffff\1\146\3\uffff\17\172\1\uffff\24\172\1\uffff\7\172"+
        "\1\146\6\172\2\uffff\6\172\1\uffff\4\172\1\uffff\3\172\1\uffff\4"+
        "\172\1\uffff\15\172\1\146\7\172\1\uffff\4\172\1\uffff\2\172\1\uffff"+
        "\3\172\1\uffff\1\172\1\uffff\14\172\1\uffff\1\172\1\146\1\uffff"+
        "\2\172\4\uffff\5\172\2\uffff\2\172\2\uffff\1\172\1\uffff\1\172\1"+
        "\uffff\10\172\1\146\1\uffff\3\172\5\uffff\4\172\1\uffff\2\172\1"+
        "\uffff\1\172\1\146\2\172\1\uffff\6\172\1\uffff\1\71\2\uffff\4\172"+
        "\1\uffff\11\172\1\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\32\uffff\1\63\1\64\3\uffff\1\72"+
        "\3\uffff\1\67\4\uffff\1\70\15\uffff\1\20\1\17\1\21\1\22\21\uffff"+
        "\1\73\1\uffff\1\65\1\uffff\1\66\1\71\1\74\17\uffff\1\51\24\uffff"+
        "\1\56\16\uffff\1\36\1\26\6\uffff\1\13\4\uffff\1\37\3\uffff\1\43"+
        "\4\uffff\1\27\25\uffff\1\11\4\uffff\1\61\2\uffff\1\16\3\uffff\1"+
        "\24\1\uffff\1\32\14\uffff\1\57\2\uffff\1\7\2\uffff\1\46\1\44\1\10"+
        "\1\45\5\uffff\1\55\1\34\2\uffff\1\40\1\25\1\uffff\1\33\1\uffff\1"+
        "\42\11\uffff\1\15\3\uffff\1\14\1\62\1\30\1\31\1\23\4\uffff\1\52"+
        "\2\uffff\1\50\4\uffff\1\12\6\uffff\1\60\1\uffff\1\47\1\53\4\uffff"+
        "\1\41\11\uffff\1\35\1\uffff\1\54";
    static final String DFA12_specialS =
        "\u0126\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\46\2\uffff\1\46\22\uffff\1\46\6\uffff\1\41\1\1\1\2\1\4\1"+
            "\uffff\1\3\1\43\1\42\1\47\12\44\1\uffff\1\5\1\15\1\6\1\16\2"+
            "\uffff\1\22\1\34\1\27\1\36\1\32\1\20\2\45\1\24\1\45\1\23\1\26"+
            "\2\45\1\30\1\37\1\31\1\33\1\17\1\35\1\25\1\40\1\21\3\45\6\uffff"+
            "\1\10\1\7\1\27\1\36\1\32\1\20\2\45\1\13\1\45\1\23\1\26\2\45"+
            "\1\30\1\37\1\31\1\33\1\17\1\11\1\14\1\12\1\21\3\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\56\1\57\6\uffff\1\53\3\56\1\55\1\56\24\54\4\uffff\1\54"+
            "\1\uffff\1\53\3\56\1\55\1\56\2\54\1\51\17\54\1\50\1\54",
            "\12\56\1\57\6\uffff\6\56\5\54\1\62\1\54\1\61\1\54\1\63\12"+
            "\54\4\uffff\1\54\1\uffff\6\56\5\54\1\62\1\54\1\61\1\54\1\63"+
            "\2\54\1\60\7\54",
            "\12\54\1\57\6\uffff\21\54\1\65\10\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\64\14\54\1\65\10\54",
            "\12\54\1\57\6\uffff\1\67\31\54\4\uffff\1\54\1\uffff\1\66\31"+
            "\54",
            "\12\54\1\57\6\uffff\15\54\1\71\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\70\14\54",
            "\12\54\1\57\6\uffff\17\54\1\74\2\54\1\73\7\54\4\uffff\1\54"+
            "\1\uffff\17\54\1\74\2\54\1\73\1\54\1\72\5\54",
            "\1\75",
            "\1\77",
            "\12\54\1\57\6\uffff\4\54\1\101\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\101\25\54",
            "\12\56\1\57\6\uffff\6\56\2\54\1\103\10\54\1\102\10\54\4\uffff"+
            "\1\54\1\uffff\6\56\2\54\1\103\10\54\1\102\10\54",
            "\12\54\1\57\6\uffff\7\54\1\105\1\104\21\54\4\uffff\1\54\1"+
            "\uffff\7\54\1\105\1\104\21\54",
            "\12\56\1\57\6\uffff\6\56\5\54\1\62\1\54\1\61\1\54\1\63\12"+
            "\54\4\uffff\1\54\1\uffff\6\56\5\54\1\62\1\54\1\61\1\54\1\63"+
            "\12\54",
            "\12\54\1\57\6\uffff\4\54\1\106\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\106\25\54",
            "\12\54\1\57\6\uffff\15\54\1\71\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\71\14\54",
            "\12\54\1\57\6\uffff\17\54\1\74\2\54\1\73\7\54\4\uffff\1\54"+
            "\1\uffff\17\54\1\74\2\54\1\73\7\54",
            "\12\54\1\57\6\uffff\10\54\1\107\5\54\1\110\13\54\4\uffff\1"+
            "\54\1\uffff\10\54\1\107\5\54\1\110\13\54",
            "\12\56\1\57\6\uffff\6\56\10\54\1\111\2\54\1\112\10\54\4\uffff"+
            "\1\54\1\uffff\6\56\10\54\1\111\2\54\1\112\10\54",
            "\12\54\1\57\6\uffff\15\54\1\113\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\113\14\54",
            "\12\54\1\57\6\uffff\24\54\1\114\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\114\5\54",
            "\12\56\1\57\6\uffff\1\115\5\56\24\54\4\uffff\1\54\1\uffff"+
            "\1\115\5\56\24\54",
            "\12\54\1\57\6\uffff\4\54\1\116\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\116\25\54",
            "\12\56\1\57\6\uffff\1\53\3\56\1\55\1\56\24\54\4\uffff\1\54"+
            "\1\uffff\1\53\3\56\1\55\1\56\24\54",
            "\12\54\1\57\6\uffff\21\54\1\65\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\65\10\54",
            "\12\56\1\57\6\uffff\4\56\1\117\1\56\13\54\1\120\10\54\4\uffff"+
            "\1\54\1\uffff\4\56\1\117\1\56\13\54\1\120\10\54",
            "\12\54\1\57\6\uffff\21\54\1\121\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\121\10\54",
            "\12\54\1\57\6\uffff\1\67\31\54\4\uffff\1\54\1\uffff\1\67\31"+
            "\54",
            "",
            "",
            "\1\122\2\uffff\12\123",
            "\1\126\1\uffff\12\125\7\uffff\6\127\32\uffff\6\127",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\130\4\uffff\1\122",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\23\54\1\131"+
            "\6\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\6\54\1\132"+
            "\23\54",
            "",
            "\12\133\1\57\6\uffff\6\133\15\54\1\134\6\54\4\uffff\1\54\1"+
            "\uffff\6\133\15\54\1\134\6\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\133\1\57\6\uffff\6\133\1\135\23\54\4\uffff\1\54\1\uffff"+
            "\6\133\1\135\23\54",
            "\12\133\1\57\6\uffff\6\133\24\54\4\uffff\1\54\1\uffff\6\133"+
            "\24\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\2\54\1\136"+
            "\27\54",
            "\12\54\1\57\6\uffff\3\54\1\140\24\54\1\137\1\54\4\uffff\1"+
            "\54\1\uffff\3\54\1\140\24\54\1\137\1\54",
            "\12\54\1\57\6\uffff\13\54\1\141\16\54\4\uffff\1\54\1\uffff"+
            "\13\54\1\141\16\54",
            "\12\54\1\57\6\uffff\17\54\1\142\12\54\4\uffff\1\54\1\uffff"+
            "\17\54\1\142\12\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\27\54\1\143"+
            "\2\54",
            "\12\54\1\57\6\uffff\24\54\1\144\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\144\5\54",
            "\12\54\1\57\6\uffff\13\54\1\146\16\54\4\uffff\1\54\1\uffff"+
            "\13\54\1\146\5\54\1\145\10\54",
            "\12\54\1\57\6\uffff\13\54\1\146\16\54\4\uffff\1\54\1\uffff"+
            "\13\54\1\146\16\54",
            "\12\54\1\57\6\uffff\3\54\1\153\16\54\1\152\1\151\6\54\4\uffff"+
            "\1\54\1\uffff\3\54\1\153\16\54\1\152\1\147\6\54",
            "\12\54\1\57\6\uffff\3\54\1\153\16\54\1\152\1\151\6\54\4\uffff"+
            "\1\54\1\uffff\3\54\1\153\16\54\1\152\1\151\6\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\10\54\1\154"+
            "\21\54",
            "\12\54\1\57\6\uffff\4\54\1\155\3\54\1\156\21\54\4\uffff\1"+
            "\54\1\uffff\4\54\1\155\3\54\1\156\21\54",
            "\12\54\1\57\6\uffff\3\54\1\157\26\54\4\uffff\1\54\1\uffff"+
            "\3\54\1\157\26\54",
            "",
            "",
            "",
            "",
            "\12\54\1\57\6\uffff\13\54\1\160\7\54\1\161\6\54\4\uffff\1"+
            "\54\1\uffff\13\54\1\160\7\54\1\161\6\54",
            "\12\54\1\57\6\uffff\16\54\1\162\13\54\4\uffff\1\54\1\uffff"+
            "\16\54\1\162\13\54",
            "\12\54\1\57\6\uffff\21\54\1\163\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\163\10\54",
            "\12\54\1\57\6\uffff\23\54\1\164\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\164\6\54",
            "\12\54\1\57\6\uffff\4\54\1\165\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\165\25\54",
            "\12\54\1\57\6\uffff\30\54\1\166\1\54\4\uffff\1\54\1\uffff"+
            "\30\54\1\166\1\54",
            "\12\54\1\57\6\uffff\14\54\1\167\15\54\4\uffff\1\54\1\uffff"+
            "\14\54\1\167\15\54",
            "\12\54\1\57\6\uffff\2\54\1\170\27\54\4\uffff\1\54\1\uffff"+
            "\2\54\1\170\27\54",
            "\12\54\1\57\6\uffff\13\54\1\173\1\54\1\172\6\54\1\171\5\54"+
            "\4\uffff\1\54\1\uffff\13\54\1\173\1\54\1\172\6\54\1\171\5\54",
            "\12\54\1\57\6\uffff\4\54\1\174\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\174\25\54",
            "\12\54\1\57\6\uffff\4\54\1\176\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\176\25\54",
            "\12\54\1\57\6\uffff\16\54\1\177\13\54\4\uffff\1\54\1\uffff"+
            "\16\54\1\177\13\54",
            "\12\133\1\57\6\uffff\2\133\1\u0080\3\133\24\54\4\uffff\1\54"+
            "\1\uffff\2\133\1\u0080\3\133\24\54",
            "\12\54\1\57\6\uffff\25\54\1\u0081\4\54\4\uffff\1\54\1\uffff"+
            "\25\54\1\u0081\4\54",
            "\12\133\1\57\6\uffff\6\133\5\54\1\u0082\16\54\4\uffff\1\54"+
            "\1\uffff\6\133\5\54\1\u0082\16\54",
            "\12\54\1\57\6\uffff\16\54\1\u0083\13\54\4\uffff\1\54\1\uffff"+
            "\16\54\1\u0083\13\54",
            "\12\54\1\57\6\uffff\10\54\1\u0084\21\54\4\uffff\1\54\1\uffff"+
            "\10\54\1\u0084\21\54",
            "",
            "\1\126\1\uffff\12\123",
            "",
            "\1\126\1\uffff\12\u0085\7\uffff\6\127\32\uffff\6\127",
            "",
            "",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\4\54\1\u0086"+
            "\25\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\10\54\1\u0087"+
            "\21\54",
            "\12\u0088\1\57\6\uffff\6\u0088\24\54\4\uffff\1\54\1\uffff"+
            "\6\u0088\24\54",
            "\12\54\1\57\6\uffff\2\54\1\u0089\27\54\4\uffff\1\54\1\uffff"+
            "\2\54\1\u0089\27\54",
            "\12\54\1\57\6\uffff\10\54\1\u008a\21\54\4\uffff\1\54\1\uffff"+
            "\10\54\1\u008a\21\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\10\54\1\u008b"+
            "\21\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\13\54\1\u008e\16\54\4\uffff\1\54\1\uffff"+
            "\13\54\1\u008e\16\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\23\54\1\u008f"+
            "\6\54",
            "\12\54\1\57\6\uffff\15\54\1\u0090\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\u0090\14\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\2\54\1\u0091"+
            "\5\54\1\u0092\21\54",
            "\12\54\1\57\6\uffff\24\54\1\u0093\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\u0093\5\54",
            "\12\54\1\57\6\uffff\16\54\1\u0095\13\54\4\uffff\1\54\1\uffff"+
            "\16\54\1\u0095\13\54",
            "",
            "\12\54\1\57\6\uffff\16\54\1\u0095\13\54\4\uffff\1\54\1\uffff"+
            "\16\54\1\u0095\13\54",
            "\12\54\1\57\6\uffff\4\54\1\u0096\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u0096\25\54",
            "\12\54\1\57\6\uffff\4\54\1\u0097\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u0097\25\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\3\54\1\u0098"+
            "\26\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\15\54\1\u009a\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\u009a\14\54",
            "\12\54\1\57\6\uffff\1\u009b\31\54\4\uffff\1\54\1\uffff\1\u009b"+
            "\31\54",
            "\12\54\1\57\6\uffff\4\54\1\u009c\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u009c\25\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\14\54\1\u009e\15\54\4\uffff\1\54\1\uffff"+
            "\14\54\1\u009e\15\54",
            "\12\54\1\57\6\uffff\22\54\1\u009f\7\54\4\uffff\1\54\1\uffff"+
            "\22\54\1\u009f\7\54",
            "\12\54\1\57\6\uffff\7\54\1\u00a0\22\54\4\uffff\1\54\1\uffff"+
            "\7\54\1\u00a0\22\54",
            "\12\54\1\57\6\uffff\21\54\1\u00a1\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\u00a1\10\54",
            "\12\54\1\57\6\uffff\22\54\1\u00a3\7\54\4\uffff\1\54\1\uffff"+
            "\22\54\1\u00a3\7\54",
            "\12\54\1\57\6\uffff\10\54\1\u00a4\21\54\4\uffff\1\54\1\uffff"+
            "\10\54\1\u00a4\21\54",
            "\12\54\1\57\6\uffff\1\u00a5\31\54\4\uffff\1\54\1\uffff\1\u00a5"+
            "\31\54",
            "\12\54\1\57\6\uffff\15\54\1\u00a6\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\u00a6\14\54",
            "\12\54\1\57\6\uffff\22\54\1\u00a7\7\54\4\uffff\1\54\1\uffff"+
            "\22\54\1\u00a7\7\54",
            "\12\54\1\57\6\uffff\24\54\1\u00a8\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\u00a8\5\54",
            "\12\54\1\57\6\uffff\1\u00a9\31\54\4\uffff\1\54\1\uffff\1\u00a9"+
            "\31\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\21\54\1\u00aa\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\u00aa\10\54",
            "\12\u0088\1\57\6\uffff\6\u0088\1\54\1\u00ab\22\54\4\uffff"+
            "\1\54\1\uffff\6\u0088\1\54\1\u00ab\22\54",
            "\12\54\1\57\6\uffff\4\54\1\u00ac\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u00ac\25\54",
            "\12\54\1\57\6\uffff\4\54\1\u00ad\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u00ad\25\54",
            "\12\54\1\57\6\uffff\17\54\1\u00ae\12\54\4\uffff\1\54\1\uffff"+
            "\17\54\1\u00ae\12\54",
            "\12\54\1\57\6\uffff\14\54\1\u00af\15\54\4\uffff\1\54\1\uffff"+
            "\14\54\1\u00af\15\54",
            "\1\126\1\uffff\12\u00b0\7\uffff\6\127\32\uffff\6\127",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\1\u00b1\31"+
            "\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\15\54\1\u00b2"+
            "\14\54",
            "\12\u00b3\1\57\6\uffff\6\u00b3\24\54\4\uffff\1\54\1\uffff"+
            "\6\u00b3\24\54",
            "\12\54\1\57\6\uffff\7\54\1\u00b4\22\54\4\uffff\1\54\1\uffff"+
            "\7\54\1\u00b4\22\54",
            "\12\54\1\57\6\uffff\15\54\1\u00b5\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\u00b5\14\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\10\54\1\u00b6"+
            "\21\54",
            "",
            "",
            "\12\54\1\57\6\uffff\30\54\1\u00b7\1\54\4\uffff\1\54\1\uffff"+
            "\30\54\1\u00b7\1\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\2\54\1\u00b9\27\54\4\uffff\1\54\1\uffff"+
            "\2\54\1\u00b9\27\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\7\54\1\u00ba"+
            "\22\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\15\54\1\u00bb"+
            "\14\54",
            "\12\54\1\57\6\uffff\4\54\1\u00bc\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u00bc\25\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\21\54\1\u00be\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\u00be\10\54",
            "\12\54\1\57\6\uffff\27\54\1\u00bf\2\54\4\uffff\1\54\1\uffff"+
            "\27\54\1\u00bf\2\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\1\57\6\uffff\6\54\1\u00c1\23\54\4\uffff\1\54\1\uffff"+
            "\6\54\1\u00c1\23\54",
            "\12\54\1\57\6\uffff\23\54\1\u00c2\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00c2\6\54",
            "\12\54\1\57\6\uffff\2\54\1\u00c3\27\54\4\uffff\1\54\1\uffff"+
            "\2\54\1\u00c3\27\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\23\54\1\u00c5\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00c5\6\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\4\54\1\u00c7\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u00c7\25\54",
            "",
            "\12\54\1\57\6\uffff\17\54\1\u00c8\12\54\4\uffff\1\54\1\uffff"+
            "\17\54\1\u00c8\12\54",
            "\12\54\1\57\6\uffff\23\54\1\u00c9\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00c9\6\54",
            "\12\54\1\57\6\uffff\13\54\1\u00ca\16\54\4\uffff\1\54\1\uffff"+
            "\13\54\1\u00ca\16\54",
            "\12\54\1\57\6\uffff\23\54\1\u00cb\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00cb\6\54",
            "\12\54\1\57\6\uffff\10\54\1\u00cc\21\54\4\uffff\1\54\1\uffff"+
            "\10\54\1\u00cc\21\54",
            "\12\54\1\57\6\uffff\14\54\1\u00cd\15\54\4\uffff\1\54\1\uffff"+
            "\14\54\1\u00cd\15\54",
            "\12\54\1\57\6\uffff\23\54\1\u00ce\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00ce\6\54",
            "\12\54\1\57\6\uffff\24\54\1\u00cf\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\u00cf\5\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\u00d0\1\uffff\32\54",
            "\12\54\1\57\6\uffff\21\54\1\u00d1\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\u00d1\10\54",
            "\12\54\1\57\6\uffff\23\54\1\u00d2\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00d2\6\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\1\u00d4\31\54\4\uffff\1\54\1\uffff\1\u00d4"+
            "\31\54",
            "\1\126\1\uffff\12\u00d5\7\uffff\6\127\32\uffff\6\127",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\23\54\1\u00d7"+
            "\6\54",
            "\12\u00d8\1\57\6\uffff\6\u00d8\24\54\4\uffff\1\54\1\uffff"+
            "\6\u00d8\24\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\1\57\6\uffff\1\u00dd\31\54\4\uffff\1\54\1\uffff\1\u00dd"+
            "\31\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\1\u00de\31"+
            "\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\23\54\1\u00df"+
            "\6\54",
            "\12\54\1\57\6\uffff\22\54\1\u00e0\7\54\4\uffff\1\54\1\uffff"+
            "\22\54\1\u00e0\7\54",
            "",
            "\12\54\1\57\6\uffff\23\54\1\u00e1\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00e1\6\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\4\54\1\u00e4\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u00e4\25\54",
            "\12\54\1\57\6\uffff\23\54\1\u00e5\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00e5\6\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\1\u00e8\31\54\4\uffff\1\54\1\uffff\1\u00e8"+
            "\31\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\u00ea\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\22\54\1\u00ec\7\54\4\uffff\1\54\1\uffff"+
            "\22\54\1\u00ec\7\54",
            "\12\54\1\57\6\uffff\15\54\1\u00ed\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\u00ed\14\54",
            "\12\54\1\57\6\uffff\4\54\1\u00ee\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u00ee\25\54",
            "\12\54\1\57\6\uffff\14\54\1\u00ef\15\54\4\uffff\1\54\1\uffff"+
            "\14\54\1\u00ef\15\54",
            "\12\54\1\57\6\uffff\20\54\1\u00f0\11\54\4\uffff\1\54\1\uffff"+
            "\20\54\1\u00f0\11\54",
            "\12\54\1\57\6\uffff\22\54\1\u00f1\7\54\4\uffff\1\54\1\uffff"+
            "\22\54\1\u00f1\7\54",
            "\12\54\1\57\6\uffff\4\54\1\u00f2\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u00f2\25\54",
            "",
            "\12\54\1\57\6\uffff\21\54\1\u00f3\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\u00f3\10\54",
            "\1\126\1\uffff\12\u00f4\7\uffff\6\127\32\uffff\6\127",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\u00f6\1\57\6\uffff\6\u00f6\24\54\4\uffff\1\54\1\uffff"+
            "\6\u00f6\24\54",
            "",
            "",
            "",
            "",
            "\12\54\1\57\6\uffff\23\54\1\u00f7\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u00f7\6\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\21\54\1\u00f8"+
            "\10\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\12\54\1\57\6\uffff\2\54\1\u00fe\27\54\4\uffff\1\54\1\uffff"+
            "\2\54\1\u00fe\27\54",
            "",
            "\12\54\1\57\6\uffff\20\54\1\u00ff\11\54\4\uffff\1\54\1\uffff"+
            "\20\54\1\u00ff\11\54",
            "",
            "\12\54\1\57\6\uffff\23\54\1\u0100\6\54\4\uffff\1\54\1\uffff"+
            "\23\54\1\u0100\6\54",
            "\12\54\1\57\6\uffff\5\54\1\u0101\24\54\4\uffff\1\54\1\uffff"+
            "\5\54\1\u0101\24\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\24\54\1\u0103\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\u0103\5\54",
            "\12\54\1\57\6\uffff\4\54\1\u0104\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u0104\25\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\30\54\1\u0106\1\54\4\uffff\1\54\1\uffff"+
            "\30\54\1\u0106\1\54",
            "\1\126\1\uffff\12\u0107\7\uffff\6\127\32\uffff\6\127",
            "",
            "\12\u0108\1\57\6\uffff\6\u0108\24\54\4\uffff\1\54\1\uffff"+
            "\6\u0108\24\54",
            "\12\54\1\57\6\uffff\4\54\1\u0109\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u0109\25\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "",
            "",
            "",
            "\12\54\1\57\6\uffff\4\54\1\u010b\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u010b\25\54",
            "\12\54\1\57\6\uffff\24\54\1\u010c\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\u010c\5\54",
            "\12\54\1\57\6\uffff\4\54\1\u010d\25\54\4\uffff\1\54\1\uffff"+
            "\4\54\1\u010d\25\54",
            "\12\54\1\57\6\uffff\1\u010e\31\54\4\uffff\1\54\1\uffff\1\u010e"+
            "\31\54",
            "",
            "\12\54\1\57\6\uffff\16\54\1\u010f\13\54\4\uffff\1\54\1\uffff"+
            "\16\54\1\u010f\13\54",
            "\12\54\1\57\6\uffff\3\54\1\u0110\26\54\4\uffff\1\54\1\uffff"+
            "\3\54\1\u0110\26\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\126\1\uffff\12\u0112\7\uffff\6\127\32\uffff\6\127",
            "\1\127\2\uffff\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\16\54\1\u0115\13\54\4\uffff\1\54\1\uffff"+
            "\16\54\1\u0115\13\54",
            "\12\54\1\57\6\uffff\15\54\1\u0116\14\54\4\uffff\1\54\1\uffff"+
            "\15\54\1\u0116\14\54",
            "\12\54\1\57\6\uffff\14\54\1\u0117\15\54\4\uffff\1\54\1\uffff"+
            "\14\54\1\u0117\15\54",
            "\12\54\1\57\6\uffff\21\54\1\u0118\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\u0118\10\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\127\1\126\1\uffff\12\123",
            "",
            "",
            "\12\54\1\57\6\uffff\21\54\1\u011a\10\54\4\uffff\1\54\1\uffff"+
            "\21\54\1\u011a\10\54",
            "\12\54\1\57\6\uffff\2\54\1\u011b\27\54\4\uffff\1\54\1\uffff"+
            "\2\54\1\u011b\27\54",
            "\12\54\1\57\6\uffff\10\54\1\u011c\21\54\4\uffff\1\54\1\uffff"+
            "\10\54\1\u011c\21\54",
            "\12\54\1\57\6\uffff\24\54\1\u011d\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\u011d\5\54",
            "",
            "\12\54\1\57\6\uffff\24\54\1\u011e\5\54\4\uffff\1\54\1\uffff"+
            "\24\54\1\u011e\5\54",
            "\12\54\1\57\6\uffff\30\54\1\u011f\1\54\4\uffff\1\54\1\uffff"+
            "\30\54\1\u011f\1\54",
            "\12\54\1\57\6\uffff\13\54\1\u0120\16\54\4\uffff\1\54\1\uffff"+
            "\13\54\1\u0120\16\54",
            "\12\54\1\57\6\uffff\14\54\1\u0121\15\54\4\uffff\1\54\1\uffff"+
            "\14\54\1\u0121\15\54",
            "\12\54\1\57\6\uffff\14\54\1\u0122\15\54\4\uffff\1\54\1\uffff"+
            "\14\54\1\u0122\15\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\30\54\1\u0124\1\54\4\uffff\1\54\1\uffff"+
            "\30\54\1\u0124\1\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\1\57\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | K_SELECT | K_FROM | K_WHERE | K_AND | K_KEY | K_INSERT | K_UPDATE | K_WITH | K_LIMIT | K_USING | K_CONSISTENCY | K_LEVEL | K_USE | K_FIRST | K_REVERSED | K_COUNT | K_SET | K_BEGIN | K_APPLY | K_BATCH | K_TRUNCATE | K_DELETE | K_IN | K_CREATE | K_KEYSPACE | K_COLUMNFAMILY | K_INDEX | K_ON | K_DROP | K_PRIMARY | K_INTO | K_VALUES | STRING_LITERAL | RANGEOP | INTEGER | FLOAT | IDENT | COMPIDENT | UUID | WS | COMMENT | MULTILINE_COMMENT );";
        }
    }
 

}