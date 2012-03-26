// $ANTLR 3.2 Sep 23, 2009 12:02:23 E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g 2012-02-13 16:08:03

    package org.apache.cassandra.cql;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.Collections;
    import java.util.List;
    import java.util.ArrayList;
    import org.apache.cassandra.thrift.ConsistencyLevel;
    import org.apache.cassandra.thrift.InvalidRequestException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CqlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "K_USE", "IDENT", "K_SELECT", "K_COUNT", "K_FROM", "STRING_LITERAL", "INTEGER", "K_USING", "K_CONSISTENCY", "K_LEVEL", "K_WHERE", "K_LIMIT", "K_FIRST", "K_REVERSED", "RANGEOP", "K_AND", "K_INSERT", "K_INTO", "K_KEY", "K_VALUES", "K_BEGIN", "K_BATCH", "K_APPLY", "K_UPDATE", "K_SET", "K_DELETE", "K_IN", "K_CREATE", "K_KEYSPACE", "K_WITH", "COMPIDENT", "K_COLUMNFAMILY", "K_PRIMARY", "FLOAT", "K_INDEX", "K_ON", "K_DROP", "UUID", "K_TRUNCATE", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "N", "D", "K", "Y", "I", "U", "P", "G", "Q", "V", "B", "X", "J", "Z", "DIGIT", "LETTER", "HEX", "WS", "COMMENT", "MULTILINE_COMMENT", "'('", "')'", "','", "'\\*'", "';'", "'='", "'bytea'", "'ascii'", "'text'", "'varchar'", "'int'", "'varint'", "'bigint'", "'uuid'", "'<'", "'<='", "'>='", "'>'"
    };
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
    public static final int K_COUNT=7;
    public static final int T__80=80;
    public static final int K_KEYSPACE=32;
    public static final int T__81=81;
    public static final int A=54;
    public static final int T__82=82;
    public static final int B=65;
    public static final int T__83=83;
    public static final int C=46;
    public static final int L=45;
    public static final int M=51;
    public static final int N=55;
    public static final int O=50;
    public static final int H=53;
    public static final int I=59;
    public static final int K_UPDATE=27;
    public static final int J=67;
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

    // delegates
    // delegators


        public CqlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CqlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CqlParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g"; }


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



    // $ANTLR start "query"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:103:1: query returns [CQLStatement stmnt] : ( selectStatement | insertStatement | updateStatement endStmnt | batchUpdateStatement | useStatement | truncateStatement | deleteStatement | createKeyspaceStatement | createColumnFamilyStatement | createIndexStatement | dropKeyspaceStatement | dropColumnFamilyStatement );
    public final CQLStatement query() throws RecognitionException {
        CQLStatement stmnt = null;

        SelectStatement selectStatement1 = null;

        UpdateStatement insertStatement2 = null;

        UpdateStatement updateStatement3 = null;

        BatchUpdateStatement batchUpdateStatement4 = null;

        String useStatement5 = null;

        String truncateStatement6 = null;

        DeleteStatement deleteStatement7 = null;

        CreateKeyspaceStatement createKeyspaceStatement8 = null;

        CreateColumnFamilyStatement createColumnFamilyStatement9 = null;

        CreateIndexStatement createIndexStatement10 = null;

        String dropKeyspaceStatement11 = null;

        String dropColumnFamilyStatement12 = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:104:5: ( selectStatement | insertStatement | updateStatement endStmnt | batchUpdateStatement | useStatement | truncateStatement | deleteStatement | createKeyspaceStatement | createColumnFamilyStatement | createIndexStatement | dropKeyspaceStatement | dropColumnFamilyStatement )
            int alt1=12;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:104:7: selectStatement
                    {
                    pushFollow(FOLLOW_selectStatement_in_query69);
                    selectStatement1=selectStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.SELECT, selectStatement1); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:105:7: insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_query81);
                    insertStatement2=insertStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.INSERT, insertStatement2); 

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:106:7: updateStatement endStmnt
                    {
                    pushFollow(FOLLOW_updateStatement_in_query93);
                    updateStatement3=updateStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query95);
                    endStmnt();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.UPDATE, updateStatement3); 

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:107:7: batchUpdateStatement
                    {
                    pushFollow(FOLLOW_batchUpdateStatement_in_query105);
                    batchUpdateStatement4=batchUpdateStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.BATCH_UPDATE, batchUpdateStatement4); 

                    }
                    break;
                case 5 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:108:7: useStatement
                    {
                    pushFollow(FOLLOW_useStatement_in_query115);
                    useStatement5=useStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.USE, useStatement5); 

                    }
                    break;
                case 6 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:109:7: truncateStatement
                    {
                    pushFollow(FOLLOW_truncateStatement_in_query130);
                    truncateStatement6=truncateStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.TRUNCATE, truncateStatement6); 

                    }
                    break;
                case 7 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:110:7: deleteStatement
                    {
                    pushFollow(FOLLOW_deleteStatement_in_query140);
                    deleteStatement7=deleteStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.DELETE, deleteStatement7); 

                    }
                    break;
                case 8 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:111:7: createKeyspaceStatement
                    {
                    pushFollow(FOLLOW_createKeyspaceStatement_in_query152);
                    createKeyspaceStatement8=createKeyspaceStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.CREATE_KEYSPACE, createKeyspaceStatement8); 

                    }
                    break;
                case 9 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:112:7: createColumnFamilyStatement
                    {
                    pushFollow(FOLLOW_createColumnFamilyStatement_in_query162);
                    createColumnFamilyStatement9=createColumnFamilyStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.CREATE_COLUMNFAMILY, createColumnFamilyStatement9); 

                    }
                    break;
                case 10 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:113:7: createIndexStatement
                    {
                    pushFollow(FOLLOW_createIndexStatement_in_query172);
                    createIndexStatement10=createIndexStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.CREATE_INDEX, createIndexStatement10); 

                    }
                    break;
                case 11 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:114:7: dropKeyspaceStatement
                    {
                    pushFollow(FOLLOW_dropKeyspaceStatement_in_query182);
                    dropKeyspaceStatement11=dropKeyspaceStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.DROP_KEYSPACE, dropKeyspaceStatement11); 

                    }
                    break;
                case 12 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:115:7: dropColumnFamilyStatement
                    {
                    pushFollow(FOLLOW_dropColumnFamilyStatement_in_query192);
                    dropColumnFamilyStatement12=dropColumnFamilyStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.DROP_COLUMNFAMILY, dropColumnFamilyStatement12); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmnt;
    }
    // $ANTLR end "query"


    // $ANTLR start "useStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:119:1: useStatement returns [String keyspace] : K_USE IDENT endStmnt ;
    public final String useStatement() throws RecognitionException {
        String keyspace = null;

        Token IDENT13=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:120:5: ( K_USE IDENT endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:120:7: K_USE IDENT endStmnt
            {
            match(input,K_USE,FOLLOW_K_USE_in_useStatement216); 
            IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_useStatement218); 
             keyspace = (IDENT13!=null?IDENT13.getText():null); 
            pushFollow(FOLLOW_endStmnt_in_useStatement222);
            endStmnt();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return keyspace;
    }
    // $ANTLR end "useStatement"


    // $ANTLR start "selectStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:123:1: selectStatement returns [SelectStatement expr] : K_SELECT (s1= selectExpression | K_COUNT '(' s2= selectExpression ')' ) K_FROM columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE whereClause )? ( K_LIMIT rows= INTEGER )? endStmnt ;
    public final SelectStatement selectStatement() throws RecognitionException {
        SelectStatement expr = null;

        Token columnFamily=null;
        Token rows=null;
        Token K_LEVEL14=null;
        SelectExpression s1 = null;

        SelectExpression s2 = null;

        WhereClause whereClause15 = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:134:5: ( K_SELECT (s1= selectExpression | K_COUNT '(' s2= selectExpression ')' ) K_FROM columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE whereClause )? ( K_LIMIT rows= INTEGER )? endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:134:7: K_SELECT (s1= selectExpression | K_COUNT '(' s2= selectExpression ')' ) K_FROM columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE whereClause )? ( K_LIMIT rows= INTEGER )? endStmnt
            {
             
                      int numRecords = 10000;
                      SelectExpression expression = null;
                      boolean isCountOp = false;
                      ConsistencyLevel cLevel = ConsistencyLevel.ONE;
                  
            match(input,K_SELECT,FOLLOW_K_SELECT_in_selectStatement253); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:141:11: (s1= selectExpression | K_COUNT '(' s2= selectExpression ')' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT||(LA2_0>=STRING_LITERAL && LA2_0<=INTEGER)||(LA2_0>=K_FIRST && LA2_0<=K_REVERSED)||LA2_0==K_KEY||LA2_0==UUID||LA2_0==78) ) {
                alt2=1;
            }
            else if ( (LA2_0==K_COUNT) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:141:13: s1= selectExpression
                    {
                    pushFollow(FOLLOW_selectExpression_in_selectStatement269);
                    s1=selectExpression();

                    state._fsp--;

                     expression = s1; 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:142:13: K_COUNT '(' s2= selectExpression ')'
                    {
                    match(input,K_COUNT,FOLLOW_K_COUNT_in_selectStatement301); 
                    match(input,75,FOLLOW_75_in_selectStatement303); 
                    pushFollow(FOLLOW_selectExpression_in_selectStatement307);
                    s2=selectExpression();

                    state._fsp--;

                    match(input,76,FOLLOW_76_in_selectStatement309); 
                     expression = s2; isCountOp = true; 

                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_selectStatement335); 
            columnFamily=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:145:11: ( K_USING K_CONSISTENCY K_LEVEL )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==K_USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:145:13: K_USING K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_USING,FOLLOW_K_USING_in_selectStatement365); 
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_selectStatement367); 
                    K_LEVEL14=(Token)match(input,K_LEVEL,FOLLOW_K_LEVEL_in_selectStatement369); 
                     cLevel = ConsistencyLevel.valueOf((K_LEVEL14!=null?K_LEVEL14.getText():null)); 

                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:146:11: ( K_WHERE whereClause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==K_WHERE) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:146:13: K_WHERE whereClause
                    {
                    match(input,K_WHERE,FOLLOW_K_WHERE_in_selectStatement388); 
                    pushFollow(FOLLOW_whereClause_in_selectStatement390);
                    whereClause15=whereClause();

                    state._fsp--;


                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:147:11: ( K_LIMIT rows= INTEGER )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==K_LIMIT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:147:13: K_LIMIT rows= INTEGER
                    {
                    match(input,K_LIMIT,FOLLOW_K_LIMIT_in_selectStatement407); 
                    rows=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectStatement411); 
                     numRecords = Integer.parseInt((rows!=null?rows.getText():null)); 

                    }
                    break;

            }

            pushFollow(FOLLOW_endStmnt_in_selectStatement428);
            endStmnt();

            state._fsp--;


                      return new SelectStatement(expression,
                                                 isCountOp,
                                                 (columnFamily!=null?columnFamily.getText():null),
                                                 cLevel,
                                                 whereClause15,
                                                 numRecords);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectStatement"


    // $ANTLR start "selectExpression"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:161:1: selectExpression returns [SelectExpression expr] : ( K_FIRST cols= INTEGER )? ( K_REVERSED )? (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' ) ;
    public final SelectExpression selectExpression() throws RecognitionException {
        SelectExpression expr = null;

        Token cols=null;
        Term first = null;

        Term next = null;

        Term start = null;

        Term finish = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:162:5: ( ( K_FIRST cols= INTEGER )? ( K_REVERSED )? (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:162:7: ( K_FIRST cols= INTEGER )? ( K_REVERSED )? (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' )
            {

                      int count = 10000;
                      boolean reversed = false;
                  
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:166:7: ( K_FIRST cols= INTEGER )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==K_FIRST) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:166:9: K_FIRST cols= INTEGER
                    {
                    match(input,K_FIRST,FOLLOW_K_FIRST_in_selectExpression469); 
                    cols=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectExpression473); 
                     count = Integer.parseInt((cols!=null?cols.getText():null)); 

                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:167:7: ( K_REVERSED )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==K_REVERSED) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:167:9: K_REVERSED
                    {
                    match(input,K_REVERSED,FOLLOW_K_REVERSED_in_selectExpression488); 
                     reversed = true; 

                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:168:7: (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' )
            int alt9=3;
            switch ( input.LA(1) ) {
            case K_KEY:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==K_FROM||(LA9_1>=76 && LA9_1<=77)) ) {
                    alt9=1;
                }
                else if ( (LA9_1==RANGEOP) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case STRING_LITERAL:
                {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==RANGEOP) ) {
                    alt9=2;
                }
                else if ( (LA9_2==K_FROM||(LA9_2>=76 && LA9_2<=77)) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case INTEGER:
                {
                int LA9_3 = input.LA(2);

                if ( (LA9_3==K_FROM||(LA9_3>=76 && LA9_3<=77)) ) {
                    alt9=1;
                }
                else if ( (LA9_3==RANGEOP) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 3, input);

                    throw nvae;
                }
                }
                break;
            case UUID:
                {
                int LA9_4 = input.LA(2);

                if ( (LA9_4==RANGEOP) ) {
                    alt9=2;
                }
                else if ( (LA9_4==K_FROM||(LA9_4>=76 && LA9_4<=77)) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 4, input);

                    throw nvae;
                }
                }
                break;
            case IDENT:
                {
                int LA9_5 = input.LA(2);

                if ( (LA9_5==K_FROM||(LA9_5>=76 && LA9_5<=77)) ) {
                    alt9=1;
                }
                else if ( (LA9_5==RANGEOP) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 5, input);

                    throw nvae;
                }
                }
                break;
            case 78:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:168:9: first= term ( ',' next= term )*
                    {
                    pushFollow(FOLLOW_term_in_selectExpression505);
                    first=term();

                    state._fsp--;

                     expr = new SelectExpression(first, count, reversed); 
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:169:13: ( ',' next= term )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==77) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:169:14: ',' next= term
                    	    {
                    	    match(input,77,FOLLOW_77_in_selectExpression522); 
                    	    pushFollow(FOLLOW_term_in_selectExpression526);
                    	    next=term();

                    	    state._fsp--;

                    	     expr.and(next); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:170:9: start= term RANGEOP finish= term
                    {
                    pushFollow(FOLLOW_term_in_selectExpression542);
                    start=term();

                    state._fsp--;

                    match(input,RANGEOP,FOLLOW_RANGEOP_in_selectExpression544); 
                    pushFollow(FOLLOW_term_in_selectExpression548);
                    finish=term();

                    state._fsp--;

                     expr = new SelectExpression(start, finish, count, reversed, false); 

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:171:9: '\\*'
                    {
                    match(input,78,FOLLOW_78_in_selectExpression560); 
                     expr = new SelectExpression(new Term(), new Term(), count, reversed, true); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectExpression"


    // $ANTLR start "whereClause"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:176:1: whereClause returns [WhereClause clause] : first= relation ( K_AND next= relation )* ;
    public final WhereClause whereClause() throws RecognitionException {
        WhereClause clause = null;

        Relation first = null;

        Relation next = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:177:5: (first= relation ( K_AND next= relation )* )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:177:7: first= relation ( K_AND next= relation )*
            {
            pushFollow(FOLLOW_relation_in_whereClause594);
            first=relation();

            state._fsp--;

             clause = new WhereClause(first); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:178:11: ( K_AND next= relation )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==K_AND) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:178:12: K_AND next= relation
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_whereClause610); 
            	    pushFollow(FOLLOW_relation_in_whereClause614);
            	    next=relation();

            	    state._fsp--;

            	     clause.and(next); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return clause;
    }
    // $ANTLR end "whereClause"


    // $ANTLR start "insertStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:181:1: insertStatement returns [UpdateStatement expr] : K_INSERT K_INTO columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) '(' K_KEY ( ',' column_name= term )+ ')' K_VALUES '(' key= term ( ',' column_value= term )+ ')' ( K_USING K_CONSISTENCY K_LEVEL )? endStmnt ;
    public final UpdateStatement insertStatement() throws RecognitionException {
        UpdateStatement expr = null;

        Token columnFamily=null;
        Token K_LEVEL16=null;
        Term column_name = null;

        Term key = null;

        Term column_value = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:193:5: ( K_INSERT K_INTO columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) '(' K_KEY ( ',' column_name= term )+ ')' K_VALUES '(' key= term ( ',' column_value= term )+ ')' ( K_USING K_CONSISTENCY K_LEVEL )? endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:193:7: K_INSERT K_INTO columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) '(' K_KEY ( ',' column_name= term )+ ')' K_VALUES '(' key= term ( ',' column_value= term )+ ')' ( K_USING K_CONSISTENCY K_LEVEL )? endStmnt
            {

                      ConsistencyLevel cLevel = ConsistencyLevel.ONE;
                      Map<Term, Term> columns = new HashMap<Term, Term>();

                      List<Term> columnNames  = new ArrayList<Term>();
                      List<Term> columnValues = new ArrayList<Term>();
                  
            match(input,K_INSERT,FOLLOW_K_INSERT_in_insertStatement649); 
            match(input,K_INTO,FOLLOW_K_INTO_in_insertStatement651); 
            columnFamily=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,75,FOLLOW_75_in_insertStatement679); 
            match(input,K_KEY,FOLLOW_K_KEY_in_insertStatement681); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:201:24: ( ',' column_name= term )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==77) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:201:26: ',' column_name= term
            	    {
            	    match(input,77,FOLLOW_77_in_insertStatement688); 
            	    pushFollow(FOLLOW_term_in_insertStatement692);
            	    column_name=term();

            	    state._fsp--;

            	     columnNames.add(column_name); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            match(input,76,FOLLOW_76_in_insertStatement700); 
            match(input,K_VALUES,FOLLOW_K_VALUES_in_insertStatement710); 
            match(input,75,FOLLOW_75_in_insertStatement722); 
            pushFollow(FOLLOW_term_in_insertStatement726);
            key=term();

            state._fsp--;

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:203:24: ( ',' column_value= term )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==77) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:203:26: ',' column_value= term
            	    {
            	    match(input,77,FOLLOW_77_in_insertStatement730); 
            	    pushFollow(FOLLOW_term_in_insertStatement734);
            	    column_value=term();

            	    state._fsp--;

            	     columnValues.add(column_value); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            match(input,76,FOLLOW_76_in_insertStatement740); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:204:9: ( K_USING K_CONSISTENCY K_LEVEL )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==K_USING) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:204:11: K_USING K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_USING,FOLLOW_K_USING_in_insertStatement752); 
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_insertStatement754); 
                    K_LEVEL16=(Token)match(input,K_LEVEL,FOLLOW_K_LEVEL_in_insertStatement756); 
                     cLevel = ConsistencyLevel.valueOf((K_LEVEL16!=null?K_LEVEL16.getText():null)); 

                    }
                    break;

            }

            pushFollow(FOLLOW_endStmnt_in_insertStatement769);
            endStmnt();

            state._fsp--;


                      return new UpdateStatement((columnFamily!=null?columnFamily.getText():null), cLevel, columnNames, columnValues, key);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "insertStatement"


    // $ANTLR start "batchUpdateStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:211:1: batchUpdateStatement returns [BatchUpdateStatement expr] : K_BEGIN K_BATCH ( K_USING K_CONSISTENCY K_LEVEL )? u1= updateStatement ( ';' )? (uN= updateStatement ( ';' )? )* K_APPLY K_BATCH EOF ;
    public final BatchUpdateStatement batchUpdateStatement() throws RecognitionException {
        BatchUpdateStatement expr = null;

        Token K_LEVEL17=null;
        UpdateStatement u1 = null;

        UpdateStatement uN = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:219:5: ( K_BEGIN K_BATCH ( K_USING K_CONSISTENCY K_LEVEL )? u1= updateStatement ( ';' )? (uN= updateStatement ( ';' )? )* K_APPLY K_BATCH EOF )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:219:7: K_BEGIN K_BATCH ( K_USING K_CONSISTENCY K_LEVEL )? u1= updateStatement ( ';' )? (uN= updateStatement ( ';' )? )* K_APPLY K_BATCH EOF
            {

                      ConsistencyLevel cLevel = ConsistencyLevel.ONE;
                      List<UpdateStatement> updates = new ArrayList<UpdateStatement>();
                  
            match(input,K_BEGIN,FOLLOW_K_BEGIN_in_batchUpdateStatement808); 
            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchUpdateStatement810); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:223:23: ( K_USING K_CONSISTENCY K_LEVEL )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==K_USING) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:223:25: K_USING K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_USING,FOLLOW_K_USING_in_batchUpdateStatement814); 
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_batchUpdateStatement816); 
                    K_LEVEL17=(Token)match(input,K_LEVEL,FOLLOW_K_LEVEL_in_batchUpdateStatement818); 
                     cLevel = ConsistencyLevel.valueOf((K_LEVEL17!=null?K_LEVEL17.getText():null)); 

                    }
                    break;

            }

            pushFollow(FOLLOW_updateStatement_in_batchUpdateStatement837);
            u1=updateStatement();

            state._fsp--;

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:224:30: ( ';' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==79) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:224:30: ';'
                    {
                    match(input,79,FOLLOW_79_in_batchUpdateStatement839); 

                    }
                    break;

            }

             updates.add(u1); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:224:56: (uN= updateStatement ( ';' )? )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==K_UPDATE) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:224:58: uN= updateStatement ( ';' )?
            	    {
            	    pushFollow(FOLLOW_updateStatement_in_batchUpdateStatement848);
            	    uN=updateStatement();

            	    state._fsp--;

            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:224:77: ( ';' )?
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==79) ) {
            	        alt16=1;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:224:77: ';'
            	            {
            	            match(input,79,FOLLOW_79_in_batchUpdateStatement850); 

            	            }
            	            break;

            	    }

            	     updates.add(uN); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match(input,K_APPLY,FOLLOW_K_APPLY_in_batchUpdateStatement864); 
            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchUpdateStatement866); 
            match(input,EOF,FOLLOW_EOF_in_batchUpdateStatement868); 

                      return new BatchUpdateStatement(updates, cLevel);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "batchUpdateStatement"


    // $ANTLR start "updateStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:231:1: updateStatement returns [UpdateStatement expr] : K_UPDATE columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? K_SET termPair[columns] ( ',' termPair[columns] )* K_WHERE K_KEY '=' key= term ;
    public final UpdateStatement updateStatement() throws RecognitionException {
        UpdateStatement expr = null;

        Token columnFamily=null;
        Token K_LEVEL18=null;
        Term key = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:243:5: ( K_UPDATE columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? K_SET termPair[columns] ( ',' termPair[columns] )* K_WHERE K_KEY '=' key= term )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:243:7: K_UPDATE columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? K_SET termPair[columns] ( ',' termPair[columns] )* K_WHERE K_KEY '=' key= term
            {

                      ConsistencyLevel cLevel = null;
                      Map<Term, Term> columns = new HashMap<Term, Term>();
                  
            match(input,K_UPDATE,FOLLOW_K_UPDATE_in_updateStatement907); 
            columnFamily=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:248:11: ( K_USING K_CONSISTENCY K_LEVEL )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==K_USING) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:248:12: K_USING K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_USING,FOLLOW_K_USING_in_updateStatement936); 
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_updateStatement938); 
                    K_LEVEL18=(Token)match(input,K_LEVEL,FOLLOW_K_LEVEL_in_updateStatement940); 
                     cLevel = ConsistencyLevel.valueOf((K_LEVEL18!=null?K_LEVEL18.getText():null)); 

                    }
                    break;

            }

            match(input,K_SET,FOLLOW_K_SET_in_updateStatement956); 
            pushFollow(FOLLOW_termPair_in_updateStatement958);
            termPair(columns);

            state._fsp--;

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:249:35: ( ',' termPair[columns] )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==77) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:249:36: ',' termPair[columns]
            	    {
            	    match(input,77,FOLLOW_77_in_updateStatement962); 
            	    pushFollow(FOLLOW_termPair_in_updateStatement964);
            	    termPair(columns);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match(input,K_WHERE,FOLLOW_K_WHERE_in_updateStatement979); 
            match(input,K_KEY,FOLLOW_K_KEY_in_updateStatement981); 
            match(input,80,FOLLOW_80_in_updateStatement983); 
            pushFollow(FOLLOW_term_in_updateStatement987);
            key=term();

            state._fsp--;


                      return new UpdateStatement((columnFamily!=null?columnFamily.getText():null), cLevel, columns, key);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "updateStatement"


    // $ANTLR start "deleteStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:256:1: deleteStatement returns [DeleteStatement expr] : K_DELETE (cols= termList )? K_FROM columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? K_WHERE ( K_KEY '=' key= term | K_KEY K_IN '(' keys= termList ')' )? endStmnt ;
    public final DeleteStatement deleteStatement() throws RecognitionException {
        DeleteStatement expr = null;

        Token columnFamily=null;
        List<Term> cols = null;

        Term key = null;

        List<Term> keys = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:267:5: ( K_DELETE (cols= termList )? K_FROM columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? K_WHERE ( K_KEY '=' key= term | K_KEY K_IN '(' keys= termList ')' )? endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:267:7: K_DELETE (cols= termList )? K_FROM columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? K_WHERE ( K_KEY '=' key= term | K_KEY K_IN '(' keys= termList ')' )? endStmnt
            {

                      ConsistencyLevel cLevel = ConsistencyLevel.ONE;
                      List<Term> keyList = null;
                      List<Term> columnsList = Collections.emptyList();
                  
            match(input,K_DELETE,FOLLOW_K_DELETE_in_deleteStatement1026); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:273:11: (cols= termList )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IDENT||(LA20_0>=STRING_LITERAL && LA20_0<=INTEGER)||LA20_0==K_KEY||LA20_0==UUID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:273:13: cols= termList
                    {
                    pushFollow(FOLLOW_termList_in_deleteStatement1042);
                    cols=termList();

                    state._fsp--;

                     columnsList = cols; 

                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_deleteStatement1058); 
            columnFamily=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:274:68: ( K_USING K_CONSISTENCY K_LEVEL )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==K_USING) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:274:70: K_USING K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_USING,FOLLOW_K_USING_in_deleteStatement1078); 
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_deleteStatement1080); 
                    match(input,K_LEVEL,FOLLOW_K_LEVEL_in_deleteStatement1082); 

                    }
                    break;

            }

            match(input,K_WHERE,FOLLOW_K_WHERE_in_deleteStatement1097); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:275:19: ( K_KEY '=' key= term | K_KEY K_IN '(' keys= termList ')' )?
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==K_KEY) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==80) ) {
                    alt22=1;
                }
                else if ( (LA22_1==K_IN) ) {
                    alt22=2;
                }
            }
            switch (alt22) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:275:21: K_KEY '=' key= term
                    {
                    match(input,K_KEY,FOLLOW_K_KEY_in_deleteStatement1101); 
                    match(input,80,FOLLOW_80_in_deleteStatement1103); 
                    pushFollow(FOLLOW_term_in_deleteStatement1107);
                    key=term();

                    state._fsp--;

                     keyList = Collections.singletonList(key); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:276:21: K_KEY K_IN '(' keys= termList ')'
                    {
                    match(input,K_KEY,FOLLOW_K_KEY_in_deleteStatement1141); 
                    match(input,K_IN,FOLLOW_K_IN_in_deleteStatement1143); 
                    match(input,75,FOLLOW_75_in_deleteStatement1145); 
                    pushFollow(FOLLOW_termList_in_deleteStatement1149);
                    keys=termList();

                    state._fsp--;

                     keyList = keys; 
                    match(input,76,FOLLOW_76_in_deleteStatement1153); 

                    }
                    break;

            }

            pushFollow(FOLLOW_endStmnt_in_deleteStatement1176);
            endStmnt();

            state._fsp--;


                      return new DeleteStatement(columnsList, (columnFamily!=null?columnFamily.getText():null), cLevel, keyList);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "deleteStatement"


    // $ANTLR start "createKeyspaceStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:283:1: createKeyspaceStatement returns [CreateKeyspaceStatement expr] : K_CREATE K_KEYSPACE keyspace= ( IDENT | STRING_LITERAL | INTEGER ) K_WITH a1= ( COMPIDENT | IDENT ) '=' v1= ( STRING_LITERAL | INTEGER | IDENT ) ( K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT ) )* endStmnt ;
    public final CreateKeyspaceStatement createKeyspaceStatement() throws RecognitionException {
        CreateKeyspaceStatement expr = null;

        Token keyspace=null;
        Token a1=null;
        Token v1=null;
        Token aN=null;
        Token vN=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:285:5: ( K_CREATE K_KEYSPACE keyspace= ( IDENT | STRING_LITERAL | INTEGER ) K_WITH a1= ( COMPIDENT | IDENT ) '=' v1= ( STRING_LITERAL | INTEGER | IDENT ) ( K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT ) )* endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:285:7: K_CREATE K_KEYSPACE keyspace= ( IDENT | STRING_LITERAL | INTEGER ) K_WITH a1= ( COMPIDENT | IDENT ) '=' v1= ( STRING_LITERAL | INTEGER | IDENT ) ( K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT ) )* endStmnt
            {

                      Map<String, String> attrs = new HashMap<String, String>();
                  
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createKeyspaceStatement1215); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_createKeyspaceStatement1217); 
            keyspace=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,K_WITH,FOLLOW_K_WITH_in_createKeyspaceStatement1245); 
            a1=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==COMPIDENT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,80,FOLLOW_80_in_createKeyspaceStatement1260); 
            v1=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             attrs.put((a1!=null?a1.getText():null), (v1!=null?v1.getText():null)); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:290:11: ( K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==K_AND) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:290:13: K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT )
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_createKeyspaceStatement1292); 
            	    aN=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==COMPIDENT ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    match(input,80,FOLLOW_80_in_createKeyspaceStatement1306); 
            	    vN=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	     attrs.put((aN!=null?aN.getText():null), (vN!=null?vN.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            pushFollow(FOLLOW_endStmnt_in_createKeyspaceStatement1339);
            endStmnt();

            state._fsp--;


                      return new CreateKeyspaceStatement((keyspace!=null?keyspace.getText():null), attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createKeyspaceStatement"


    // $ANTLR start "createColumnFamilyStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:297:1: createColumnFamilyStatement returns [CreateColumnFamilyStatement expr] : K_CREATE K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')' )? ( K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )* )? endStmnt ;
    public final CreateColumnFamilyStatement createColumnFamilyStatement() throws RecognitionException {
        CreateColumnFamilyStatement expr = null;

        Token name=null;
        Token prop1=null;
        Token propN=null;
        String arg1 = null;

        String argN = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:305:5: ( K_CREATE K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')' )? ( K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )* )? endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:305:7: K_CREATE K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')' )? ( K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )* )? endStmnt
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createColumnFamilyStatement1374); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_createColumnFamilyStatement1376); 
            name=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             expr = new CreateColumnFamilyStatement((name!=null?name.getText():null)); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:306:7: ( '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==75) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:306:9: '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')'
                    {
                    match(input,75,FOLLOW_75_in_createColumnFamilyStatement1404); 
                    pushFollow(FOLLOW_createCfamColumns_in_createColumnFamilyStatement1406);
                    createCfamColumns(expr);

                    state._fsp--;

                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:306:37: ( ',' createCfamColumns[expr] )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==77) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:306:39: ',' createCfamColumns[expr]
                    	    {
                    	    match(input,77,FOLLOW_77_in_createColumnFamilyStatement1411); 
                    	    pushFollow(FOLLOW_createCfamColumns_in_createColumnFamilyStatement1413);
                    	    createCfamColumns(expr);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    match(input,76,FOLLOW_76_in_createColumnFamilyStatement1419); 

                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:307:7: ( K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==K_WITH) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:307:9: K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )*
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_createColumnFamilyStatement1432); 
                    prop1=(Token)match(input,IDENT,FOLLOW_IDENT_in_createColumnFamilyStatement1436); 
                    match(input,80,FOLLOW_80_in_createColumnFamilyStatement1438); 
                    pushFollow(FOLLOW_createCfamKeywordArgument_in_createColumnFamilyStatement1442);
                    arg1=createCfamKeywordArgument();

                    state._fsp--;

                     expr.addProperty((prop1!=null?prop1.getText():null), arg1); 
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:308:11: ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==K_AND) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:308:13: K_AND propN= IDENT '=' argN= createCfamKeywordArgument
                    	    {
                    	    match(input,K_AND,FOLLOW_K_AND_in_createColumnFamilyStatement1458); 
                    	    propN=(Token)match(input,IDENT,FOLLOW_IDENT_in_createColumnFamilyStatement1462); 
                    	    match(input,80,FOLLOW_80_in_createColumnFamilyStatement1464); 
                    	    pushFollow(FOLLOW_createCfamKeywordArgument_in_createColumnFamilyStatement1468);
                    	    argN=createCfamKeywordArgument();

                    	    state._fsp--;

                    	     expr.addProperty((propN!=null?propN.getText():null), argN); 

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_endStmnt_in_createColumnFamilyStatement1490);
            endStmnt();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createColumnFamilyStatement"


    // $ANTLR start "createCfamColumns"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:313:1: createCfamColumns[CreateColumnFamilyStatement expr] : (n= term v= createCfamColumnValidator | K_KEY v= createCfamColumnValidator K_PRIMARY K_KEY );
    public final void createCfamColumns(CreateColumnFamilyStatement expr) throws RecognitionException {
        Term n = null;

        String v = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:314:5: (n= term v= createCfamColumnValidator | K_KEY v= createCfamColumnValidator K_PRIMARY K_KEY )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==K_KEY) ) {
                int LA28_1 = input.LA(2);

                if ( ((LA28_1>=81 && LA28_1<=88)) ) {
                    int LA28_3 = input.LA(3);

                    if ( ((LA28_3>=76 && LA28_3<=77)) ) {
                        alt28=1;
                    }
                    else if ( (LA28_3==K_PRIMARY) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA28_1==STRING_LITERAL) ) {
                    int LA28_4 = input.LA(3);

                    if ( (LA28_4==K_PRIMARY) ) {
                        alt28=2;
                    }
                    else if ( ((LA28_4>=76 && LA28_4<=77)) ) {
                        alt28=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA28_0==IDENT||(LA28_0>=STRING_LITERAL && LA28_0<=INTEGER)||LA28_0==UUID) ) {
                alt28=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:314:7: n= term v= createCfamColumnValidator
                    {
                    pushFollow(FOLLOW_term_in_createCfamColumns1510);
                    n=term();

                    state._fsp--;

                    pushFollow(FOLLOW_createCfamColumnValidator_in_createCfamColumns1514);
                    v=createCfamColumnValidator();

                    state._fsp--;

                     expr.addColumn(n, v); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:315:7: K_KEY v= createCfamColumnValidator K_PRIMARY K_KEY
                    {
                    match(input,K_KEY,FOLLOW_K_KEY_in_createCfamColumns1524); 
                    pushFollow(FOLLOW_createCfamColumnValidator_in_createCfamColumns1528);
                    v=createCfamColumnValidator();

                    state._fsp--;

                    match(input,K_PRIMARY,FOLLOW_K_PRIMARY_in_createCfamColumns1530); 
                    match(input,K_KEY,FOLLOW_K_KEY_in_createCfamColumns1532); 
                     expr.setKeyType(v); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "createCfamColumns"


    // $ANTLR start "createCfamColumnValidator"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:318:1: createCfamColumnValidator returns [String validator] : ( comparatorType | STRING_LITERAL );
    public final String createCfamColumnValidator() throws RecognitionException {
        String validator = null;

        Token STRING_LITERAL20=null;
        CqlParser.comparatorType_return comparatorType19 = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:319:5: ( comparatorType | STRING_LITERAL )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=81 && LA29_0<=88)) ) {
                alt29=1;
            }
            else if ( (LA29_0==STRING_LITERAL) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:319:7: comparatorType
                    {
                    pushFollow(FOLLOW_comparatorType_in_createCfamColumnValidator1555);
                    comparatorType19=comparatorType();

                    state._fsp--;

                     validator = (comparatorType19!=null?input.toString(comparatorType19.start,comparatorType19.stop):null); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:320:7: STRING_LITERAL
                    {
                    STRING_LITERAL20=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_createCfamColumnValidator1565); 
                     validator = (STRING_LITERAL20!=null?STRING_LITERAL20.getText():null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return validator;
    }
    // $ANTLR end "createCfamColumnValidator"


    // $ANTLR start "createCfamKeywordArgument"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:323:1: createCfamKeywordArgument returns [String arg] : ( comparatorType | value= ( STRING_LITERAL | IDENT | INTEGER | FLOAT ) );
    public final String createCfamKeywordArgument() throws RecognitionException {
        String arg = null;

        Token value=null;
        CqlParser.comparatorType_return comparatorType21 = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:324:5: ( comparatorType | value= ( STRING_LITERAL | IDENT | INTEGER | FLOAT ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=81 && LA30_0<=88)) ) {
                alt30=1;
            }
            else if ( (LA30_0==IDENT||(LA30_0>=STRING_LITERAL && LA30_0<=INTEGER)||LA30_0==FLOAT) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:324:7: comparatorType
                    {
                    pushFollow(FOLLOW_comparatorType_in_createCfamKeywordArgument1588);
                    comparatorType21=comparatorType();

                    state._fsp--;

                     arg = (comparatorType21!=null?input.toString(comparatorType21.start,comparatorType21.stop):null); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:325:7: value= ( STRING_LITERAL | IDENT | INTEGER | FLOAT )
                    {
                    value=(Token)input.LT(1);
                    if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER)||input.LA(1)==FLOAT ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     arg = (value!=null?value.getText():null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "createCfamKeywordArgument"


    // $ANTLR start "createIndexStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:328:1: createIndexStatement returns [CreateIndexStatement expr] : K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= ( IDENT | STRING_LITERAL | INTEGER ) '(' columnName= term ')' endStmnt ;
    public final CreateIndexStatement createIndexStatement() throws RecognitionException {
        CreateIndexStatement expr = null;

        Token idxName=null;
        Token cf=null;
        Term columnName = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:330:5: ( K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= ( IDENT | STRING_LITERAL | INTEGER ) '(' columnName= term ')' endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:330:7: K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= ( IDENT | STRING_LITERAL | INTEGER ) '(' columnName= term ')' endStmnt
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createIndexStatement1641); 
            match(input,K_INDEX,FOLLOW_K_INDEX_in_createIndexStatement1643); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:330:24: (idxName= IDENT )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==IDENT) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:330:25: idxName= IDENT
                    {
                    idxName=(Token)match(input,IDENT,FOLLOW_IDENT_in_createIndexStatement1648); 

                    }
                    break;

            }

            match(input,K_ON,FOLLOW_K_ON_in_createIndexStatement1652); 
            cf=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,75,FOLLOW_75_in_createIndexStatement1670); 
            pushFollow(FOLLOW_term_in_createIndexStatement1674);
            columnName=term();

            state._fsp--;

            match(input,76,FOLLOW_76_in_createIndexStatement1676); 
            pushFollow(FOLLOW_endStmnt_in_createIndexStatement1678);
            endStmnt();

            state._fsp--;

             expr = new CreateIndexStatement((idxName!=null?idxName.getText():null), (cf!=null?cf.getText():null), columnName); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createIndexStatement"


    // $ANTLR start "dropKeyspaceStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:334:1: dropKeyspaceStatement returns [String ksp] : K_DROP K_KEYSPACE name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt ;
    public final String dropKeyspaceStatement() throws RecognitionException {
        String ksp = null;

        Token name=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:336:5: ( K_DROP K_KEYSPACE name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:336:7: K_DROP K_KEYSPACE name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropKeyspaceStatement1709); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement1711); 
            name=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_endStmnt_in_dropKeyspaceStatement1729);
            endStmnt();

            state._fsp--;

             ksp = (name!=null?name.getText():null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ksp;
    }
    // $ANTLR end "dropKeyspaceStatement"


    // $ANTLR start "dropColumnFamilyStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:339:1: dropColumnFamilyStatement returns [String cfam] : K_DROP K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt ;
    public final String dropColumnFamilyStatement() throws RecognitionException {
        String cfam = null;

        Token name=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:341:5: ( K_DROP K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:341:7: K_DROP K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropColumnFamilyStatement1754); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_dropColumnFamilyStatement1756); 
            name=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_endStmnt_in_dropColumnFamilyStatement1774);
            endStmnt();

            state._fsp--;

             cfam = (name!=null?name.getText():null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cfam;
    }
    // $ANTLR end "dropColumnFamilyStatement"

    public static class comparatorType_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "comparatorType"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:344:1: comparatorType : ( 'bytea' | 'ascii' | 'text' | 'varchar' | 'int' | 'varint' | 'bigint' | 'uuid' );
    public final CqlParser.comparatorType_return comparatorType() throws RecognitionException {
        CqlParser.comparatorType_return retval = new CqlParser.comparatorType_return();
        retval.start = input.LT(1);

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:345:5: ( 'bytea' | 'ascii' | 'text' | 'varchar' | 'int' | 'varint' | 'bigint' | 'uuid' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:
            {
            if ( (input.LA(1)>=81 && input.LA(1)<=88) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparatorType"


    // $ANTLR start "term"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:348:1: term returns [Term item] : (t= K_KEY | t= STRING_LITERAL | t= INTEGER | t= UUID | t= IDENT ) ;
    public final Term term() throws RecognitionException {
        Term item = null;

        Token t=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:349:5: ( (t= K_KEY | t= STRING_LITERAL | t= INTEGER | t= UUID | t= IDENT ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:349:7: (t= K_KEY | t= STRING_LITERAL | t= INTEGER | t= UUID | t= IDENT )
            {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:349:7: (t= K_KEY | t= STRING_LITERAL | t= INTEGER | t= UUID | t= IDENT )
            int alt32=5;
            switch ( input.LA(1) ) {
            case K_KEY:
                {
                alt32=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt32=2;
                }
                break;
            case INTEGER:
                {
                alt32=3;
                }
                break;
            case UUID:
                {
                alt32=4;
                }
                break;
            case IDENT:
                {
                alt32=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:349:9: t= K_KEY
                    {
                    t=(Token)match(input,K_KEY,FOLLOW_K_KEY_in_term1846); 

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:349:19: t= STRING_LITERAL
                    {
                    t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term1852); 

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:349:38: t= INTEGER
                    {
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_term1858); 

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:349:50: t= UUID
                    {
                    t=(Token)match(input,UUID,FOLLOW_UUID_in_term1864); 

                    }
                    break;
                case 5 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:349:59: t= IDENT
                    {
                    t=(Token)match(input,IDENT,FOLLOW_IDENT_in_term1870); 

                    }
                    break;

            }

             item = new Term((t!=null?t.getText():null), (t!=null?t.getType():0)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return item;
    }
    // $ANTLR end "term"


    // $ANTLR start "termList"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:352:1: termList returns [List<Term> items] : t1= term ( ',' tN= term )* ;
    public final List<Term> termList() throws RecognitionException {
        List<Term> items = null;

        Term t1 = null;

        Term tN = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:353:5: (t1= term ( ',' tN= term )* )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:353:7: t1= term ( ',' tN= term )*
            {
             items = new ArrayList<Term>(); 
            pushFollow(FOLLOW_term_in_termList1905);
            t1=term();

            state._fsp--;

             items.add(t1); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:354:35: ( ',' tN= term )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==77) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:354:36: ',' tN= term
            	    {
            	    match(input,77,FOLLOW_77_in_termList1910); 
            	    pushFollow(FOLLOW_term_in_termList1914);
            	    tN=term();

            	    state._fsp--;

            	     items.add(tN); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return items;
    }
    // $ANTLR end "termList"


    // $ANTLR start "termPair"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:358:1: termPair[Map<Term, Term> columns] : key= term '=' value= term ;
    public final void termPair(Map<Term, Term> columns) throws RecognitionException {
        Term key = null;

        Term value = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:359:5: (key= term '=' value= term )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:359:9: key= term '=' value= term
            {
            pushFollow(FOLLOW_term_in_termPair1941);
            key=term();

            state._fsp--;

            match(input,80,FOLLOW_80_in_termPair1943); 
            pushFollow(FOLLOW_term_in_termPair1947);
            value=term();

            state._fsp--;

             columns.put(key, value); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "termPair"


    // $ANTLR start "relation"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:363:1: relation returns [Relation rel] : (name= term ) type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term ;
    public final Relation relation() throws RecognitionException {
        Relation rel = null;

        Token type=null;
        Term name = null;

        Term t = null;


        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:364:5: ( (name= term ) type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:364:7: (name= term ) type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term
            {
             Term entity = new Term("KEY", STRING_LITERAL); 
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:365:7: (name= term )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:365:8: name= term
            {
            pushFollow(FOLLOW_term_in_relation1982);
            name=term();

            state._fsp--;

             entity = name; 

            }

            type=(Token)input.LT(1);
            if ( input.LA(1)==80||(input.LA(1)>=89 && input.LA(1)<=92) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_term_in_relation2012);
            t=term();

            state._fsp--;

             return new Relation(entity, (type!=null?type.getText():null), t); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rel;
    }
    // $ANTLR end "relation"


    // $ANTLR start "truncateStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:370:1: truncateStatement returns [String cfam] : K_TRUNCATE columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt ;
    public final String truncateStatement() throws RecognitionException {
        String cfam = null;

        Token columnFamily=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:371:5: ( K_TRUNCATE columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:371:7: K_TRUNCATE columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt
            {
            match(input,K_TRUNCATE,FOLLOW_K_TRUNCATE_in_truncateStatement2042); 
            columnFamily=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             cfam = (columnFamily!=null?columnFamily.getText():null); 
            pushFollow(FOLLOW_endStmnt_in_truncateStatement2062);
            endStmnt();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cfam;
    }
    // $ANTLR end "truncateStatement"


    // $ANTLR start "endStmnt"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:374:1: endStmnt : ( ';' )? EOF ;
    public final void endStmnt() throws RecognitionException {
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:375:5: ( ( ';' )? EOF )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:375:7: ( ';' )? EOF
            {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:375:7: ( ';' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==79) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cql/Cql.g:375:7: ';'
                    {
                    match(input,79,FOLLOW_79_in_endStmnt2079); 

                    }
                    break;

            }

            match(input,EOF,FOLLOW_EOF_in_endStmnt2083); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "endStmnt"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\17\uffff";
    static final String DFA1_eofS =
        "\17\uffff";
    static final String DFA1_minS =
        "\1\4\7\uffff\2\40\5\uffff";
    static final String DFA1_maxS =
        "\1\52\7\uffff\1\46\1\43\5\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\1\10\1\11\1\12\1\13"+
        "\1\14";
    static final String DFA1_specialS =
        "\17\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\5\1\uffff\1\1\15\uffff\1\2\3\uffff\1\4\2\uffff\1\3\1\uffff"+
            "\1\7\1\uffff\1\10\10\uffff\1\11\1\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\2\uffff\1\13\2\uffff\1\14",
            "\1\15\2\uffff\1\16",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "103:1: query returns [CQLStatement stmnt] : ( selectStatement | insertStatement | updateStatement endStmnt | batchUpdateStatement | useStatement | truncateStatement | deleteStatement | createKeyspaceStatement | createColumnFamilyStatement | createIndexStatement | dropKeyspaceStatement | dropColumnFamilyStatement );";
        }
    }
 

    public static final BitSet FOLLOW_selectStatement_in_query69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_query81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_query93 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_query95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_batchUpdateStatement_in_query105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useStatement_in_query115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncateStatement_in_query130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_query140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createKeyspaceStatement_in_query152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createColumnFamilyStatement_in_query162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createIndexStatement_in_query172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropKeyspaceStatement_in_query182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropColumnFamilyStatement_in_query192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USE_in_useStatement216 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_useStatement218 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_useStatement222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_SELECT_in_selectStatement253 = new BitSet(new long[]{0x00000200004306A0L,0x0000000000004000L});
    public static final BitSet FOLLOW_selectExpression_in_selectStatement269 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_K_COUNT_in_selectStatement301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_selectStatement303 = new BitSet(new long[]{0x0000020000430620L,0x0000000000004000L});
    public static final BitSet FOLLOW_selectExpression_in_selectStatement307 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_selectStatement309 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_K_FROM_in_selectStatement335 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_selectStatement339 = new BitSet(new long[]{0x000000000000C800L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_USING_in_selectStatement365 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_selectStatement367 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_LEVEL_in_selectStatement369 = new BitSet(new long[]{0x000000000000C000L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_WHERE_in_selectStatement388 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_whereClause_in_selectStatement390 = new BitSet(new long[]{0x0000000000008000L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_LIMIT_in_selectStatement407 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INTEGER_in_selectStatement411 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_selectStatement428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_FIRST_in_selectExpression469 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INTEGER_in_selectExpression473 = new BitSet(new long[]{0x0000020000420620L,0x0000000000004000L});
    public static final BitSet FOLLOW_K_REVERSED_in_selectExpression488 = new BitSet(new long[]{0x0000020000400620L,0x0000000000004000L});
    public static final BitSet FOLLOW_term_in_selectExpression505 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_selectExpression522 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_selectExpression526 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_term_in_selectExpression542 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RANGEOP_in_selectExpression544 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_selectExpression548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_selectExpression560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_whereClause594 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_K_AND_in_whereClause610 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_relation_in_whereClause614 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_K_INSERT_in_insertStatement649 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_K_INTO_in_insertStatement651 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_insertStatement655 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_insertStatement679 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_K_KEY_in_insertStatement681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_insertStatement688 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_insertStatement692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_insertStatement700 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_K_VALUES_in_insertStatement710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_insertStatement722 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_insertStatement726 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_insertStatement730 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_insertStatement734 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_insertStatement740 = new BitSet(new long[]{0x0000000000000800L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_USING_in_insertStatement752 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_insertStatement754 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_LEVEL_in_insertStatement756 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_insertStatement769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BEGIN_in_batchUpdateStatement808 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchUpdateStatement810 = new BitSet(new long[]{0x0000000008000800L});
    public static final BitSet FOLLOW_K_USING_in_batchUpdateStatement814 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_batchUpdateStatement816 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_LEVEL_in_batchUpdateStatement818 = new BitSet(new long[]{0x0000000008000800L});
    public static final BitSet FOLLOW_updateStatement_in_batchUpdateStatement837 = new BitSet(new long[]{0x000000000C000800L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_batchUpdateStatement839 = new BitSet(new long[]{0x000000000C000800L});
    public static final BitSet FOLLOW_updateStatement_in_batchUpdateStatement848 = new BitSet(new long[]{0x000000000C000800L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_batchUpdateStatement850 = new BitSet(new long[]{0x000000000C000800L});
    public static final BitSet FOLLOW_K_APPLY_in_batchUpdateStatement864 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchUpdateStatement866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_batchUpdateStatement868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_UPDATE_in_updateStatement907 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_updateStatement911 = new BitSet(new long[]{0x0000000010000800L});
    public static final BitSet FOLLOW_K_USING_in_updateStatement936 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_updateStatement938 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_LEVEL_in_updateStatement940 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_K_SET_in_updateStatement956 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_termPair_in_updateStatement958 = new BitSet(new long[]{0x0000000000004000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_updateStatement962 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_termPair_in_updateStatement964 = new BitSet(new long[]{0x0000000000004000L,0x0000000000002000L});
    public static final BitSet FOLLOW_K_WHERE_in_updateStatement979 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_K_KEY_in_updateStatement981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_updateStatement983 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_updateStatement987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DELETE_in_deleteStatement1026 = new BitSet(new long[]{0x0000020000400720L});
    public static final BitSet FOLLOW_termList_in_deleteStatement1042 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_K_FROM_in_deleteStatement1058 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_deleteStatement1062 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_K_USING_in_deleteStatement1078 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_deleteStatement1080 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_LEVEL_in_deleteStatement1082 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_K_WHERE_in_deleteStatement1097 = new BitSet(new long[]{0x0000000000400000L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_KEY_in_deleteStatement1101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_deleteStatement1103 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_deleteStatement1107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_KEY_in_deleteStatement1141 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_K_IN_in_deleteStatement1143 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_deleteStatement1145 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_termList_in_deleteStatement1149 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_deleteStatement1153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_deleteStatement1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createKeyspaceStatement1215 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_createKeyspaceStatement1217 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1221 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_K_WITH_in_createKeyspaceStatement1245 = new BitSet(new long[]{0x0000000400000020L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1250 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_createKeyspaceStatement1260 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1264 = new BitSet(new long[]{0x0000000000080000L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_AND_in_createKeyspaceStatement1292 = new BitSet(new long[]{0x0000000400000020L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_createKeyspaceStatement1306 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1310 = new BitSet(new long[]{0x0000000000080000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_createKeyspaceStatement1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createColumnFamilyStatement1374 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_createColumnFamilyStatement1376 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_createColumnFamilyStatement1380 = new BitSet(new long[]{0x0000000200000000L,0x0000000000008800L});
    public static final BitSet FOLLOW_75_in_createColumnFamilyStatement1404 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_createCfamColumns_in_createColumnFamilyStatement1406 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_77_in_createColumnFamilyStatement1411 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_createCfamColumns_in_createColumnFamilyStatement1413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_createColumnFamilyStatement1419 = new BitSet(new long[]{0x0000000200000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_WITH_in_createColumnFamilyStatement1432 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_createColumnFamilyStatement1436 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_createColumnFamilyStatement1438 = new BitSet(new long[]{0x0000002000000620L,0x0000000001FE0000L});
    public static final BitSet FOLLOW_createCfamKeywordArgument_in_createColumnFamilyStatement1442 = new BitSet(new long[]{0x0000000000080000L,0x0000000000008000L});
    public static final BitSet FOLLOW_K_AND_in_createColumnFamilyStatement1458 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_createColumnFamilyStatement1462 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_createColumnFamilyStatement1464 = new BitSet(new long[]{0x0000002000000620L,0x0000000001FE0000L});
    public static final BitSet FOLLOW_createCfamKeywordArgument_in_createColumnFamilyStatement1468 = new BitSet(new long[]{0x0000000000080000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_createColumnFamilyStatement1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_createCfamColumns1510 = new BitSet(new long[]{0x0000000000000200L,0x0000000001FE0000L});
    public static final BitSet FOLLOW_createCfamColumnValidator_in_createCfamColumns1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_KEY_in_createCfamColumns1524 = new BitSet(new long[]{0x0000000000000200L,0x0000000001FE0000L});
    public static final BitSet FOLLOW_createCfamColumnValidator_in_createCfamColumns1528 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_K_PRIMARY_in_createCfamColumns1530 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_K_KEY_in_createCfamColumns1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparatorType_in_createCfamColumnValidator1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_createCfamColumnValidator1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparatorType_in_createCfamKeywordArgument1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_createCfamKeywordArgument1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createIndexStatement1641 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_createIndexStatement1643 = new BitSet(new long[]{0x0000008000000020L});
    public static final BitSet FOLLOW_IDENT_in_createIndexStatement1648 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_K_ON_in_createIndexStatement1652 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_createIndexStatement1656 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_createIndexStatement1670 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_createIndexStatement1674 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_createIndexStatement1676 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_createIndexStatement1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropKeyspaceStatement1709 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement1711 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_dropKeyspaceStatement1715 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_dropKeyspaceStatement1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropColumnFamilyStatement1754 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_dropColumnFamilyStatement1756 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_dropColumnFamilyStatement1760 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_dropColumnFamilyStatement1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparatorType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_KEY_in_term1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_term1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UUID_in_term1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_termList1905 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_termList1910 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_termList1914 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_term_in_termPair1941 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_termPair1943 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_termPair1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_relation1982 = new BitSet(new long[]{0x0000000000000000L,0x000000001E010000L});
    public static final BitSet FOLLOW_set_in_relation1990 = new BitSet(new long[]{0x0000020000400620L});
    public static final BitSet FOLLOW_term_in_relation2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TRUNCATE_in_truncateStatement2042 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_set_in_truncateStatement2046 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_endStmnt_in_truncateStatement2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_endStmnt2079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_endStmnt2083 = new BitSet(new long[]{0x0000000000000002L});

}