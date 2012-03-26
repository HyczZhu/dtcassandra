// $ANTLR 3.2 Sep 23, 2009 12:02:23 E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g 2012-02-13 16:08:01

package org.apache.cassandra.cli;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class CliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NODE_CONNECT", "NODE_DESCRIBE_TABLE", "NODE_DESCRIBE_CLUSTER", "NODE_USE_TABLE", "NODE_EXIT", "NODE_HELP", "NODE_NO_OP", "NODE_SHOW_CLUSTER_NAME", "NODE_SHOW_VERSION", "NODE_SHOW_KEYSPACES", "NODE_THRIFT_GET", "NODE_THRIFT_GET_WITH_CONDITIONS", "NODE_THRIFT_SET", "NODE_THRIFT_COUNT", "NODE_THRIFT_DEL", "NODE_THRIFT_INCR", "NODE_THRIFT_DECR", "NODE_ADD_COLUMN_FAMILY", "NODE_ADD_KEYSPACE", "NODE_DEL_KEYSPACE", "NODE_DEL_COLUMN_FAMILY", "NODE_UPDATE_KEYSPACE", "NODE_UPDATE_COLUMN_FAMILY", "NODE_LIST", "NODE_TRUNCATE", "NODE_ASSUME", "NODE_CONSISTENCY_LEVEL", "NODE_COLUMN_ACCESS", "NODE_ID_LIST", "NODE_NEW_CF_ACCESS", "NODE_NEW_KEYSPACE_ACCESS", "CONVERT_TO_TYPE", "FUNCTION_CALL", "CONDITION", "CONDITIONS", "ARRAY", "HASH", "PAIR", "NODE_LIMIT", "NODE_KEY_RANGE", "SEMICOLON", "CONNECT", "HELP", "USE", "DESCRIBE", "KEYSPACE", "EXIT", "QUIT", "SHOW", "KEYSPACES", "API_VERSION", "CREATE", "UPDATE", "COLUMN", "FAMILY", "DROP", "GET", "SET", "INCR", "DECR", "DEL", "COUNT", "LIST", "TRUNCATE", "ASSUME", "CONSISTENCYLEVEL", "IntegerPositiveLiteral", "Identifier", "StringLiteral", "WITH", "TTL", "BY", "AND", "IntegerNegativeLiteral", "DoubleLiteral", "IP_ADDRESS", "CONFIG", "FILE", "LIMIT", "Letter", "Digit", "Alnum", "SingleStringCharacter", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "WS", "COMMENT", "'/'", "'CLUSTER'", "'CLUSTER NAME'", "'?'", "'AS'", "'WHERE'", "'='", "'>'", "'<'", "'>='", "'<='", "'['", "','", "']'", "'{'", "'}'", "':'", "'('", "')'", "'.'"
    };
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
    public static final int T__98=98;
    public static final int ARRAY=39;
    public static final int NODE_ADD_KEYSPACE=22;
    public static final int EXIT=50;
    public static final int NODE_THRIFT_DEL=18;
    public static final int IntegerNegativeLiteral=77;
    public static final int SEMICOLON=44;
    public static final int KEYSPACES=53;
    public static final int CONDITIONS=38;
    public static final int FILE=81;
    public static final int NODE_LIMIT=42;
    public static final int LIST=66;
    public static final int NODE_DESCRIBE_CLUSTER=6;
    public static final int IP_ADDRESS=79;
    public static final int NODE_THRIFT_SET=16;
    public static final int NODE_NO_OP=10;
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
    public static final int Digit=84;
    public static final int API_VERSION=54;
    public static final int NODE_ASSUME=29;
    public static final int CONVERT_TO_TYPE=35;
    public static final int NODE_THRIFT_GET=14;
    public static final int NODE_DEL_COLUMN_FAMILY=24;
    public static final int NODE_KEY_RANGE=43;
    public static final int KEYSPACE=49;
    public static final int StringLiteral=72;
    public static final int NODE_HELP=9;
    public static final int CONFIG=80;
    public static final int IntegerPositiveLiteral=70;
    public static final int DROP=59;
    public static final int NonEscapeCharacter=92;
    public static final int DECR=63;
    public static final int NODE_ADD_COLUMN_FAMILY=21;
    public static final int NODE_THRIFT_INCR=19;
    public static final int NODE_COLUMN_ACCESS=31;

    // delegates
    // delegators


        public CliParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CliParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return CliParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g"; }


        public void reportError(RecognitionException e) 
        {
            String errorMessage;

            if (e instanceof NoViableAltException)
            {
                errorMessage = "Command not found: `" + this.input + "`. Type 'help;' or '?' for help.";
            }
            else
            {
                errorMessage = "Syntax error at position " + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames());
            }

            throw new RuntimeException(errorMessage);
        }


    public static class root_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "root"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:138:1: root : statement ( SEMICOLON )? EOF -> statement ;
    public final CliParser.root_return root() throws RecognitionException {
        CliParser.root_return retval = new CliParser.root_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMICOLON2=null;
        Token EOF3=null;
        CliParser.statement_return statement1 = null;


        CommonTree SEMICOLON2_tree=null;
        CommonTree EOF3_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:138:5: ( statement ( SEMICOLON )? EOF -> statement )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:138:7: statement ( SEMICOLON )? EOF
            {
            pushFollow(FOLLOW_statement_in_root407);
            statement1=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement1.getTree());
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:138:17: ( SEMICOLON )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==SEMICOLON) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: SEMICOLON
                    {
                    SEMICOLON2=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_root409); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON2);


                    }
                    break;

            }

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_root412); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF3);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 138:32: -> statement
            {
                adaptor.addChild(root_0, stream_statement.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "root"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:140:1: statement : ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | -> ^( NODE_NO_OP ) );
    public final CliParser.statement_return statement() throws RecognitionException {
        CliParser.statement_return retval = new CliParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.connectStatement_return connectStatement4 = null;

        CliParser.exitStatement_return exitStatement5 = null;

        CliParser.countStatement_return countStatement6 = null;

        CliParser.describeTable_return describeTable7 = null;

        CliParser.describeCluster_return describeCluster8 = null;

        CliParser.addKeyspace_return addKeyspace9 = null;

        CliParser.addColumnFamily_return addColumnFamily10 = null;

        CliParser.updateKeyspace_return updateKeyspace11 = null;

        CliParser.updateColumnFamily_return updateColumnFamily12 = null;

        CliParser.delColumnFamily_return delColumnFamily13 = null;

        CliParser.delKeyspace_return delKeyspace14 = null;

        CliParser.useKeyspace_return useKeyspace15 = null;

        CliParser.delStatement_return delStatement16 = null;

        CliParser.getStatement_return getStatement17 = null;

        CliParser.helpStatement_return helpStatement18 = null;

        CliParser.setStatement_return setStatement19 = null;

        CliParser.incrStatement_return incrStatement20 = null;

        CliParser.showStatement_return showStatement21 = null;

        CliParser.listStatement_return listStatement22 = null;

        CliParser.truncateStatement_return truncateStatement23 = null;

        CliParser.assumeStatement_return assumeStatement24 = null;

        CliParser.consistencyLevelStatement_return consistencyLevelStatement25 = null;



        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:141:5: ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | -> ^( NODE_NO_OP ) )
            int alt2=23;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:141:7: connectStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectStatement_in_statement428);
                    connectStatement4=connectStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectStatement4.getTree());

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:142:7: exitStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_exitStatement_in_statement436);
                    exitStatement5=exitStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exitStatement5.getTree());

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:143:7: countStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_countStatement_in_statement444);
                    countStatement6=countStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, countStatement6.getTree());

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:144:7: describeTable
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_describeTable_in_statement452);
                    describeTable7=describeTable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, describeTable7.getTree());

                    }
                    break;
                case 5 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:145:7: describeCluster
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_describeCluster_in_statement460);
                    describeCluster8=describeCluster();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, describeCluster8.getTree());

                    }
                    break;
                case 6 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:146:7: addKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_addKeyspace_in_statement468);
                    addKeyspace9=addKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addKeyspace9.getTree());

                    }
                    break;
                case 7 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:147:7: addColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_addColumnFamily_in_statement476);
                    addColumnFamily10=addColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addColumnFamily10.getTree());

                    }
                    break;
                case 8 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:148:7: updateKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_updateKeyspace_in_statement484);
                    updateKeyspace11=updateKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, updateKeyspace11.getTree());

                    }
                    break;
                case 9 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:149:7: updateColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_updateColumnFamily_in_statement492);
                    updateColumnFamily12=updateColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, updateColumnFamily12.getTree());

                    }
                    break;
                case 10 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:150:7: delColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delColumnFamily_in_statement500);
                    delColumnFamily13=delColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delColumnFamily13.getTree());

                    }
                    break;
                case 11 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:151:7: delKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delKeyspace_in_statement508);
                    delKeyspace14=delKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delKeyspace14.getTree());

                    }
                    break;
                case 12 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:152:7: useKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_useKeyspace_in_statement516);
                    useKeyspace15=useKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, useKeyspace15.getTree());

                    }
                    break;
                case 13 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:153:7: delStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delStatement_in_statement524);
                    delStatement16=delStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delStatement16.getTree());

                    }
                    break;
                case 14 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:154:7: getStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getStatement_in_statement532);
                    getStatement17=getStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, getStatement17.getTree());

                    }
                    break;
                case 15 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:155:7: helpStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_helpStatement_in_statement540);
                    helpStatement18=helpStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, helpStatement18.getTree());

                    }
                    break;
                case 16 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:156:7: setStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_setStatement_in_statement548);
                    setStatement19=setStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, setStatement19.getTree());

                    }
                    break;
                case 17 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:157:7: incrStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_incrStatement_in_statement556);
                    incrStatement20=incrStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, incrStatement20.getTree());

                    }
                    break;
                case 18 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:158:7: showStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showStatement_in_statement564);
                    showStatement21=showStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showStatement21.getTree());

                    }
                    break;
                case 19 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:159:7: listStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_listStatement_in_statement572);
                    listStatement22=listStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, listStatement22.getTree());

                    }
                    break;
                case 20 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:160:7: truncateStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_truncateStatement_in_statement580);
                    truncateStatement23=truncateStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, truncateStatement23.getTree());

                    }
                    break;
                case 21 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:161:7: assumeStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assumeStatement_in_statement588);
                    assumeStatement24=assumeStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assumeStatement24.getTree());

                    }
                    break;
                case 22 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:162:7: consistencyLevelStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_consistencyLevelStatement_in_statement596);
                    consistencyLevelStatement25=consistencyLevelStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, consistencyLevelStatement25.getTree());

                    }
                    break;
                case 23 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:163:7: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 163:7: -> ^( NODE_NO_OP )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:163:10: ^( NODE_NO_OP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_NO_OP, "NODE_NO_OP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class connectStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:166:1: connectStatement : ( CONNECT host '/' port ( username password )? -> ^( NODE_CONNECT host port ( username password )? ) | CONNECT ip_address '/' port ( username password )? -> ^( NODE_CONNECT ip_address port ( username password )? ) );
    public final CliParser.connectStatement_return connectStatement() throws RecognitionException {
        CliParser.connectStatement_return retval = new CliParser.connectStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONNECT26=null;
        Token char_literal28=null;
        Token CONNECT32=null;
        Token char_literal34=null;
        CliParser.host_return host27 = null;

        CliParser.port_return port29 = null;

        CliParser.username_return username30 = null;

        CliParser.password_return password31 = null;

        CliParser.ip_address_return ip_address33 = null;

        CliParser.port_return port35 = null;

        CliParser.username_return username36 = null;

        CliParser.password_return password37 = null;


        CommonTree CONNECT26_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree CONNECT32_tree=null;
        CommonTree char_literal34_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_CONNECT=new RewriteRuleTokenStream(adaptor,"token CONNECT");
        RewriteRuleSubtreeStream stream_port=new RewriteRuleSubtreeStream(adaptor,"rule port");
        RewriteRuleSubtreeStream stream_ip_address=new RewriteRuleSubtreeStream(adaptor,"rule ip_address");
        RewriteRuleSubtreeStream stream_username=new RewriteRuleSubtreeStream(adaptor,"rule username");
        RewriteRuleSubtreeStream stream_host=new RewriteRuleSubtreeStream(adaptor,"rule host");
        RewriteRuleSubtreeStream stream_password=new RewriteRuleSubtreeStream(adaptor,"rule password");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:167:5: ( CONNECT host '/' port ( username password )? -> ^( NODE_CONNECT host port ( username password )? ) | CONNECT ip_address '/' port ( username password )? -> ^( NODE_CONNECT ip_address port ( username password )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONNECT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==Identifier) ) {
                    alt5=1;
                }
                else if ( (LA5_1==IP_ADDRESS) ) {
                    alt5=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:167:7: CONNECT host '/' port ( username password )?
                    {
                    CONNECT26=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_connectStatement625); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT26);

                    pushFollow(FOLLOW_host_in_connectStatement627);
                    host27=host();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_host.add(host27.getTree());
                    char_literal28=(Token)match(input,98,FOLLOW_98_in_connectStatement629); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_98.add(char_literal28);

                    pushFollow(FOLLOW_port_in_connectStatement631);
                    port29=port();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_port.add(port29.getTree());
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:167:29: ( username password )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==Identifier) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:167:30: username password
                            {
                            pushFollow(FOLLOW_username_in_connectStatement634);
                            username30=username();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_username.add(username30.getTree());
                            pushFollow(FOLLOW_password_in_connectStatement636);
                            password31=password();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_password.add(password31.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: password, host, port, username
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 168:9: -> ^( NODE_CONNECT host port ( username password )? )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:168:12: ^( NODE_CONNECT host port ( username password )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"), root_1);

                        adaptor.addChild(root_1, stream_host.nextTree());
                        adaptor.addChild(root_1, stream_port.nextTree());
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:168:37: ( username password )?
                        if ( stream_password.hasNext()||stream_username.hasNext() ) {
                            adaptor.addChild(root_1, stream_username.nextTree());
                            adaptor.addChild(root_1, stream_password.nextTree());

                        }
                        stream_password.reset();
                        stream_username.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:169:7: CONNECT ip_address '/' port ( username password )?
                    {
                    CONNECT32=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_connectStatement671); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT32);

                    pushFollow(FOLLOW_ip_address_in_connectStatement673);
                    ip_address33=ip_address();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ip_address.add(ip_address33.getTree());
                    char_literal34=(Token)match(input,98,FOLLOW_98_in_connectStatement675); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_98.add(char_literal34);

                    pushFollow(FOLLOW_port_in_connectStatement677);
                    port35=port();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_port.add(port35.getTree());
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:169:35: ( username password )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==Identifier) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:169:36: username password
                            {
                            pushFollow(FOLLOW_username_in_connectStatement680);
                            username36=username();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_username.add(username36.getTree());
                            pushFollow(FOLLOW_password_in_connectStatement682);
                            password37=password();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_password.add(password37.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: username, port, ip_address, password
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 170:9: -> ^( NODE_CONNECT ip_address port ( username password )? )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:170:12: ^( NODE_CONNECT ip_address port ( username password )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"), root_1);

                        adaptor.addChild(root_1, stream_ip_address.nextTree());
                        adaptor.addChild(root_1, stream_port.nextTree());
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:170:43: ( username password )?
                        if ( stream_username.hasNext()||stream_password.hasNext() ) {
                            adaptor.addChild(root_1, stream_username.nextTree());
                            adaptor.addChild(root_1, stream_password.nextTree());

                        }
                        stream_username.reset();
                        stream_password.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "connectStatement"

    public static class helpStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "helpStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:173:1: helpStatement : ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP DESCRIBE KEYSPACE -> ^( NODE_HELP NODE_DESCRIBE_TABLE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) );
    public final CliParser.helpStatement_return helpStatement() throws RecognitionException {
        CliParser.helpStatement_return retval = new CliParser.helpStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token HELP38=null;
        Token HELP39=null;
        Token HELP40=null;
        Token CONNECT41=null;
        Token HELP42=null;
        Token USE43=null;
        Token HELP44=null;
        Token DESCRIBE45=null;
        Token KEYSPACE46=null;
        Token HELP47=null;
        Token DESCRIBE48=null;
        Token string_literal49=null;
        Token HELP50=null;
        Token EXIT51=null;
        Token HELP52=null;
        Token QUIT53=null;
        Token HELP54=null;
        Token SHOW55=null;
        Token string_literal56=null;
        Token HELP57=null;
        Token SHOW58=null;
        Token KEYSPACES59=null;
        Token HELP60=null;
        Token SHOW61=null;
        Token API_VERSION62=null;
        Token HELP63=null;
        Token CREATE64=null;
        Token KEYSPACE65=null;
        Token HELP66=null;
        Token UPDATE67=null;
        Token KEYSPACE68=null;
        Token HELP69=null;
        Token CREATE70=null;
        Token COLUMN71=null;
        Token FAMILY72=null;
        Token HELP73=null;
        Token UPDATE74=null;
        Token COLUMN75=null;
        Token FAMILY76=null;
        Token HELP77=null;
        Token DROP78=null;
        Token KEYSPACE79=null;
        Token HELP80=null;
        Token DROP81=null;
        Token COLUMN82=null;
        Token FAMILY83=null;
        Token HELP84=null;
        Token GET85=null;
        Token HELP86=null;
        Token SET87=null;
        Token HELP88=null;
        Token INCR89=null;
        Token HELP90=null;
        Token DECR91=null;
        Token HELP92=null;
        Token DEL93=null;
        Token HELP94=null;
        Token COUNT95=null;
        Token HELP96=null;
        Token LIST97=null;
        Token HELP98=null;
        Token TRUNCATE99=null;
        Token HELP100=null;
        Token ASSUME101=null;
        Token HELP102=null;
        Token CONSISTENCYLEVEL103=null;
        Token HELP104=null;
        Token char_literal105=null;

        CommonTree HELP38_tree=null;
        CommonTree HELP39_tree=null;
        CommonTree HELP40_tree=null;
        CommonTree CONNECT41_tree=null;
        CommonTree HELP42_tree=null;
        CommonTree USE43_tree=null;
        CommonTree HELP44_tree=null;
        CommonTree DESCRIBE45_tree=null;
        CommonTree KEYSPACE46_tree=null;
        CommonTree HELP47_tree=null;
        CommonTree DESCRIBE48_tree=null;
        CommonTree string_literal49_tree=null;
        CommonTree HELP50_tree=null;
        CommonTree EXIT51_tree=null;
        CommonTree HELP52_tree=null;
        CommonTree QUIT53_tree=null;
        CommonTree HELP54_tree=null;
        CommonTree SHOW55_tree=null;
        CommonTree string_literal56_tree=null;
        CommonTree HELP57_tree=null;
        CommonTree SHOW58_tree=null;
        CommonTree KEYSPACES59_tree=null;
        CommonTree HELP60_tree=null;
        CommonTree SHOW61_tree=null;
        CommonTree API_VERSION62_tree=null;
        CommonTree HELP63_tree=null;
        CommonTree CREATE64_tree=null;
        CommonTree KEYSPACE65_tree=null;
        CommonTree HELP66_tree=null;
        CommonTree UPDATE67_tree=null;
        CommonTree KEYSPACE68_tree=null;
        CommonTree HELP69_tree=null;
        CommonTree CREATE70_tree=null;
        CommonTree COLUMN71_tree=null;
        CommonTree FAMILY72_tree=null;
        CommonTree HELP73_tree=null;
        CommonTree UPDATE74_tree=null;
        CommonTree COLUMN75_tree=null;
        CommonTree FAMILY76_tree=null;
        CommonTree HELP77_tree=null;
        CommonTree DROP78_tree=null;
        CommonTree KEYSPACE79_tree=null;
        CommonTree HELP80_tree=null;
        CommonTree DROP81_tree=null;
        CommonTree COLUMN82_tree=null;
        CommonTree FAMILY83_tree=null;
        CommonTree HELP84_tree=null;
        CommonTree GET85_tree=null;
        CommonTree HELP86_tree=null;
        CommonTree SET87_tree=null;
        CommonTree HELP88_tree=null;
        CommonTree INCR89_tree=null;
        CommonTree HELP90_tree=null;
        CommonTree DECR91_tree=null;
        CommonTree HELP92_tree=null;
        CommonTree DEL93_tree=null;
        CommonTree HELP94_tree=null;
        CommonTree COUNT95_tree=null;
        CommonTree HELP96_tree=null;
        CommonTree LIST97_tree=null;
        CommonTree HELP98_tree=null;
        CommonTree TRUNCATE99_tree=null;
        CommonTree HELP100_tree=null;
        CommonTree ASSUME101_tree=null;
        CommonTree HELP102_tree=null;
        CommonTree CONSISTENCYLEVEL103_tree=null;
        CommonTree HELP104_tree=null;
        CommonTree char_literal105_tree=null;
        RewriteRuleTokenStream stream_EXIT=new RewriteRuleTokenStream(adaptor,"token EXIT");
        RewriteRuleTokenStream stream_HELP=new RewriteRuleTokenStream(adaptor,"token HELP");
        RewriteRuleTokenStream stream_DEL=new RewriteRuleTokenStream(adaptor,"token DEL");
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_COUNT=new RewriteRuleTokenStream(adaptor,"token COUNT");
        RewriteRuleTokenStream stream_KEYSPACES=new RewriteRuleTokenStream(adaptor,"token KEYSPACES");
        RewriteRuleTokenStream stream_API_VERSION=new RewriteRuleTokenStream(adaptor,"token API_VERSION");
        RewriteRuleTokenStream stream_CONSISTENCYLEVEL=new RewriteRuleTokenStream(adaptor,"token CONSISTENCYLEVEL");
        RewriteRuleTokenStream stream_LIST=new RewriteRuleTokenStream(adaptor,"token LIST");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleTokenStream stream_QUIT=new RewriteRuleTokenStream(adaptor,"token QUIT");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_CONNECT=new RewriteRuleTokenStream(adaptor,"token CONNECT");
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_INCR=new RewriteRuleTokenStream(adaptor,"token INCR");
        RewriteRuleTokenStream stream_ASSUME=new RewriteRuleTokenStream(adaptor,"token ASSUME");
        RewriteRuleTokenStream stream_TRUNCATE=new RewriteRuleTokenStream(adaptor,"token TRUNCATE");
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_DECR=new RewriteRuleTokenStream(adaptor,"token DECR");
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleTokenStream stream_USE=new RewriteRuleTokenStream(adaptor,"token USE");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:174:5: ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP DESCRIBE KEYSPACE -> ^( NODE_HELP NODE_DESCRIBE_TABLE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) )
            int alt6=28;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:174:7: HELP HELP
                    {
                    HELP38=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement726); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP38);

                    HELP39=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement728); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP39);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 175:9: -> ^( NODE_HELP NODE_HELP )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:175:12: ^( NODE_HELP NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:176:7: HELP CONNECT
                    {
                    HELP40=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement753); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP40);

                    CONNECT41=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_helpStatement755); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT41);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 177:9: -> ^( NODE_HELP NODE_CONNECT )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:177:12: ^( NODE_HELP NODE_CONNECT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:178:7: HELP USE
                    {
                    HELP42=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement780); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP42);

                    USE43=(Token)match(input,USE,FOLLOW_USE_in_helpStatement782); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_USE.add(USE43);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 179:9: -> ^( NODE_HELP NODE_USE_TABLE )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:179:12: ^( NODE_HELP NODE_USE_TABLE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_USE_TABLE, "NODE_USE_TABLE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:180:7: HELP DESCRIBE KEYSPACE
                    {
                    HELP44=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement807); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP44);

                    DESCRIBE45=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_helpStatement809); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE45);

                    KEYSPACE46=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement811); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE46);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 181:9: -> ^( NODE_HELP NODE_DESCRIBE_TABLE )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:181:12: ^( NODE_HELP NODE_DESCRIBE_TABLE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DESCRIBE_TABLE, "NODE_DESCRIBE_TABLE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:182:7: HELP DESCRIBE 'CLUSTER'
                    {
                    HELP47=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP47);

                    DESCRIBE48=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_helpStatement838); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE48);

                    string_literal49=(Token)match(input,99,FOLLOW_99_in_helpStatement840); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_99.add(string_literal49);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 183:9: -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:183:12: ^( NODE_HELP NODE_DESCRIBE_CLUSTER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DESCRIBE_CLUSTER, "NODE_DESCRIBE_CLUSTER"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:184:7: HELP EXIT
                    {
                    HELP50=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement864); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP50);

                    EXIT51=(Token)match(input,EXIT,FOLLOW_EXIT_in_helpStatement866); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXIT.add(EXIT51);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 185:9: -> ^( NODE_HELP NODE_EXIT )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:185:12: ^( NODE_HELP NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:186:7: HELP QUIT
                    {
                    HELP52=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement891); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP52);

                    QUIT53=(Token)match(input,QUIT,FOLLOW_QUIT_in_helpStatement893); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUIT.add(QUIT53);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 187:9: -> ^( NODE_HELP NODE_EXIT )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:187:12: ^( NODE_HELP NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:188:7: HELP SHOW 'CLUSTER NAME'
                    {
                    HELP54=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement918); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP54);

                    SHOW55=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement920); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW55);

                    string_literal56=(Token)match(input,100,FOLLOW_100_in_helpStatement922); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_100.add(string_literal56);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 189:9: -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:189:12: ^( NODE_HELP NODE_SHOW_CLUSTER_NAME )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_CLUSTER_NAME, "NODE_SHOW_CLUSTER_NAME"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:190:7: HELP SHOW KEYSPACES
                    {
                    HELP57=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement946); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP57);

                    SHOW58=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement948); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW58);

                    KEYSPACES59=(Token)match(input,KEYSPACES,FOLLOW_KEYSPACES_in_helpStatement950); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACES.add(KEYSPACES59);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 191:9: -> ^( NODE_HELP NODE_SHOW_KEYSPACES )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:191:12: ^( NODE_HELP NODE_SHOW_KEYSPACES )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_KEYSPACES, "NODE_SHOW_KEYSPACES"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:192:7: HELP SHOW API_VERSION
                    {
                    HELP60=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement975); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP60);

                    SHOW61=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement977); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW61);

                    API_VERSION62=(Token)match(input,API_VERSION,FOLLOW_API_VERSION_in_helpStatement979); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_API_VERSION.add(API_VERSION62);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 193:9: -> ^( NODE_HELP NODE_SHOW_VERSION )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:193:12: ^( NODE_HELP NODE_SHOW_VERSION )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_VERSION, "NODE_SHOW_VERSION"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:194:7: HELP CREATE KEYSPACE
                    {
                    HELP63=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1003); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP63);

                    CREATE64=(Token)match(input,CREATE,FOLLOW_CREATE_in_helpStatement1005); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE64);

                    KEYSPACE65=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1007); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE65);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 195:9: -> ^( NODE_HELP NODE_ADD_KEYSPACE )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:195:12: ^( NODE_HELP NODE_ADD_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ADD_KEYSPACE, "NODE_ADD_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:196:7: HELP UPDATE KEYSPACE
                    {
                    HELP66=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1032); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP66);

                    UPDATE67=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_helpStatement1034); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE67);

                    KEYSPACE68=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1036); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE68);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 197:9: -> ^( NODE_HELP NODE_UPDATE_KEYSPACE )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:197:12: ^( NODE_HELP NODE_UPDATE_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_UPDATE_KEYSPACE, "NODE_UPDATE_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 13 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:198:7: HELP CREATE COLUMN FAMILY
                    {
                    HELP69=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1060); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP69);

                    CREATE70=(Token)match(input,CREATE,FOLLOW_CREATE_in_helpStatement1062); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE70);

                    COLUMN71=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1064); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN71);

                    FAMILY72=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1066); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY72);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 199:9: -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:199:12: ^( NODE_HELP NODE_ADD_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ADD_COLUMN_FAMILY, "NODE_ADD_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 14 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:200:7: HELP UPDATE COLUMN FAMILY
                    {
                    HELP73=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1091); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP73);

                    UPDATE74=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_helpStatement1093); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE74);

                    COLUMN75=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1095); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN75);

                    FAMILY76=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1097); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY76);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 201:9: -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:201:12: ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_UPDATE_COLUMN_FAMILY, "NODE_UPDATE_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 15 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:202:7: HELP DROP KEYSPACE
                    {
                    HELP77=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1121); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP77);

                    DROP78=(Token)match(input,DROP,FOLLOW_DROP_in_helpStatement1123); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DROP.add(DROP78);

                    KEYSPACE79=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1125); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE79);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 203:9: -> ^( NODE_HELP NODE_DEL_KEYSPACE )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:203:12: ^( NODE_HELP NODE_DEL_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DEL_KEYSPACE, "NODE_DEL_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 16 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:204:7: HELP DROP COLUMN FAMILY
                    {
                    HELP80=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1150); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP80);

                    DROP81=(Token)match(input,DROP,FOLLOW_DROP_in_helpStatement1152); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DROP.add(DROP81);

                    COLUMN82=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1154); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN82);

                    FAMILY83=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1156); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY83);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 205:9: -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:205:12: ^( NODE_HELP NODE_DEL_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DEL_COLUMN_FAMILY, "NODE_DEL_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 17 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:206:7: HELP GET
                    {
                    HELP84=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1181); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP84);

                    GET85=(Token)match(input,GET,FOLLOW_GET_in_helpStatement1183); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET85);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 207:9: -> ^( NODE_HELP NODE_THRIFT_GET )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:207:12: ^( NODE_HELP NODE_THRIFT_GET )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_GET, "NODE_THRIFT_GET"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 18 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:208:7: HELP SET
                    {
                    HELP86=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1208); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP86);

                    SET87=(Token)match(input,SET,FOLLOW_SET_in_helpStatement1210); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SET.add(SET87);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 209:9: -> ^( NODE_HELP NODE_THRIFT_SET )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:209:12: ^( NODE_HELP NODE_THRIFT_SET )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_SET, "NODE_THRIFT_SET"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 19 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:210:7: HELP INCR
                    {
                    HELP88=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1235); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP88);

                    INCR89=(Token)match(input,INCR,FOLLOW_INCR_in_helpStatement1237); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCR.add(INCR89);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 211:9: -> ^( NODE_HELP NODE_THRIFT_INCR )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:211:12: ^( NODE_HELP NODE_THRIFT_INCR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_INCR, "NODE_THRIFT_INCR"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 20 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:212:7: HELP DECR
                    {
                    HELP90=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1261); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP90);

                    DECR91=(Token)match(input,DECR,FOLLOW_DECR_in_helpStatement1263); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DECR.add(DECR91);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 213:9: -> ^( NODE_HELP NODE_THRIFT_DECR )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:213:12: ^( NODE_HELP NODE_THRIFT_DECR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_DECR, "NODE_THRIFT_DECR"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 21 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:214:7: HELP DEL
                    {
                    HELP92=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1287); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP92);

                    DEL93=(Token)match(input,DEL,FOLLOW_DEL_in_helpStatement1289); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEL.add(DEL93);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 215:9: -> ^( NODE_HELP NODE_THRIFT_DEL )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:215:12: ^( NODE_HELP NODE_THRIFT_DEL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_DEL, "NODE_THRIFT_DEL"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 22 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:216:7: HELP COUNT
                    {
                    HELP94=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1314); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP94);

                    COUNT95=(Token)match(input,COUNT,FOLLOW_COUNT_in_helpStatement1316); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COUNT.add(COUNT95);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 217:9: -> ^( NODE_HELP NODE_THRIFT_COUNT )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:217:12: ^( NODE_HELP NODE_THRIFT_COUNT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_COUNT, "NODE_THRIFT_COUNT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 23 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:218:7: HELP LIST
                    {
                    HELP96=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1341); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP96);

                    LIST97=(Token)match(input,LIST,FOLLOW_LIST_in_helpStatement1343); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LIST.add(LIST97);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 219:9: -> ^( NODE_HELP NODE_LIST )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:219:12: ^( NODE_HELP NODE_LIST )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_LIST, "NODE_LIST"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 24 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:220:7: HELP TRUNCATE
                    {
                    HELP98=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1368); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP98);

                    TRUNCATE99=(Token)match(input,TRUNCATE,FOLLOW_TRUNCATE_in_helpStatement1370); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRUNCATE.add(TRUNCATE99);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 221:9: -> ^( NODE_HELP NODE_TRUNCATE )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:221:12: ^( NODE_HELP NODE_TRUNCATE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_TRUNCATE, "NODE_TRUNCATE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 25 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:222:7: HELP ASSUME
                    {
                    HELP100=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1394); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP100);

                    ASSUME101=(Token)match(input,ASSUME,FOLLOW_ASSUME_in_helpStatement1396); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSUME.add(ASSUME101);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 223:9: -> ^( NODE_HELP NODE_ASSUME )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:223:12: ^( NODE_HELP NODE_ASSUME )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ASSUME, "NODE_ASSUME"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 26 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:224:7: HELP CONSISTENCYLEVEL
                    {
                    HELP102=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1420); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP102);

                    CONSISTENCYLEVEL103=(Token)match(input,CONSISTENCYLEVEL,FOLLOW_CONSISTENCYLEVEL_in_helpStatement1422); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONSISTENCYLEVEL.add(CONSISTENCYLEVEL103);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 225:9: -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:225:12: ^( NODE_HELP NODE_CONSISTENCY_LEVEL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_CONSISTENCY_LEVEL, "NODE_CONSISTENCY_LEVEL"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 27 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:226:7: HELP
                    {
                    HELP104=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1446); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP104);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 227:9: -> ^( NODE_HELP )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:227:12: ^( NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 28 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:228:7: '?'
                    {
                    char_literal105=(Token)match(input,101,FOLLOW_101_in_helpStatement1469); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_101.add(char_literal105);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 229:9: -> ^( NODE_HELP )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:229:12: ^( NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "helpStatement"

    public static class exitStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exitStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:232:1: exitStatement : ( QUIT -> ^( NODE_EXIT ) | EXIT -> ^( NODE_EXIT ) );
    public final CliParser.exitStatement_return exitStatement() throws RecognitionException {
        CliParser.exitStatement_return retval = new CliParser.exitStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token QUIT106=null;
        Token EXIT107=null;

        CommonTree QUIT106_tree=null;
        CommonTree EXIT107_tree=null;
        RewriteRuleTokenStream stream_EXIT=new RewriteRuleTokenStream(adaptor,"token EXIT");
        RewriteRuleTokenStream stream_QUIT=new RewriteRuleTokenStream(adaptor,"token QUIT");

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:233:5: ( QUIT -> ^( NODE_EXIT ) | EXIT -> ^( NODE_EXIT ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==QUIT) ) {
                alt7=1;
            }
            else if ( (LA7_0==EXIT) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:233:7: QUIT
                    {
                    QUIT106=(Token)match(input,QUIT,FOLLOW_QUIT_in_exitStatement1504); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUIT.add(QUIT106);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 233:12: -> ^( NODE_EXIT )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:233:15: ^( NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:234:7: EXIT
                    {
                    EXIT107=(Token)match(input,EXIT,FOLLOW_EXIT_in_exitStatement1518); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXIT.add(EXIT107);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 234:12: -> ^( NODE_EXIT )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:234:15: ^( NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exitStatement"

    public static class getStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:237:1: getStatement : ( GET columnFamilyExpr ( 'AS' typeIdentifier )? -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ) | GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )* -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )* ) );
    public final CliParser.getStatement_return getStatement() throws RecognitionException {
        CliParser.getStatement_return retval = new CliParser.getStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token limit=null;
        Token GET108=null;
        Token string_literal110=null;
        Token GET112=null;
        Token string_literal114=null;
        Token string_literal116=null;
        Token string_literal118=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr109 = null;

        CliParser.typeIdentifier_return typeIdentifier111 = null;

        CliParser.columnFamily_return columnFamily113 = null;

        CliParser.getCondition_return getCondition115 = null;

        CliParser.getCondition_return getCondition117 = null;


        CommonTree limit_tree=null;
        CommonTree GET108_tree=null;
        CommonTree string_literal110_tree=null;
        CommonTree GET112_tree=null;
        CommonTree string_literal114_tree=null;
        CommonTree string_literal116_tree=null;
        CommonTree string_literal118_tree=null;
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleSubtreeStream stream_typeIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule typeIdentifier");
        RewriteRuleSubtreeStream stream_getCondition=new RewriteRuleSubtreeStream(adaptor,"rule getCondition");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:238:5: ( GET columnFamilyExpr ( 'AS' typeIdentifier )? -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ) | GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )* -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )* ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==GET) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==Identifier) ) {
                    int LA11_2 = input.LA(3);

                    if ( (LA11_2==103) ) {
                        alt11=2;
                    }
                    else if ( (LA11_2==109) ) {
                        alt11=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:238:7: GET columnFamilyExpr ( 'AS' typeIdentifier )?
                    {
                    GET108=(Token)match(input,GET,FOLLOW_GET_in_getStatement1541); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET108);

                    pushFollow(FOLLOW_columnFamilyExpr_in_getStatement1543);
                    columnFamilyExpr109=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr109.getTree());
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:238:28: ( 'AS' typeIdentifier )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==102) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:238:29: 'AS' typeIdentifier
                            {
                            string_literal110=(Token)match(input,102,FOLLOW_102_in_getStatement1546); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_102.add(string_literal110);

                            pushFollow(FOLLOW_typeIdentifier_in_getStatement1548);
                            typeIdentifier111=typeIdentifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_typeIdentifier.add(typeIdentifier111.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: typeIdentifier, columnFamilyExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 239:9: -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:239:12: ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_GET, "NODE_THRIFT_GET"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:239:47: ( ^( CONVERT_TO_TYPE typeIdentifier ) )?
                        if ( stream_typeIdentifier.hasNext() ) {
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:239:49: ^( CONVERT_TO_TYPE typeIdentifier )
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONVERT_TO_TYPE, "CONVERT_TO_TYPE"), root_2);

                            adaptor.addChild(root_2, stream_typeIdentifier.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_typeIdentifier.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:240:7: GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )*
                    {
                    GET112=(Token)match(input,GET,FOLLOW_GET_in_getStatement1586); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET112);

                    pushFollow(FOLLOW_columnFamily_in_getStatement1588);
                    columnFamily113=columnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily113.getTree());
                    string_literal114=(Token)match(input,103,FOLLOW_103_in_getStatement1590); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_103.add(string_literal114);

                    pushFollow(FOLLOW_getCondition_in_getStatement1592);
                    getCondition115=getCondition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_getCondition.add(getCondition115.getTree());
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:240:45: ( 'AND' getCondition )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==AND) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:240:46: 'AND' getCondition
                    	    {
                    	    string_literal116=(Token)match(input,AND,FOLLOW_AND_in_getStatement1595); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AND.add(string_literal116);

                    	    pushFollow(FOLLOW_getCondition_in_getStatement1597);
                    	    getCondition117=getCondition();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_getCondition.add(getCondition117.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:240:67: ( 'LIMIT' limit= IntegerPositiveLiteral )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==LIMIT) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:240:68: 'LIMIT' limit= IntegerPositiveLiteral
                    	    {
                    	    string_literal118=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_getStatement1602); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_LIMIT.add(string_literal118);

                    	    limit=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_getStatement1606); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(limit);


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: getCondition, limit, columnFamily
                    // token labels: limit
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_limit=new RewriteRuleTokenStream(adaptor,"token limit",limit);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 241:9: -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )* )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:241:12: ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_GET_WITH_CONDITIONS, "NODE_THRIFT_GET_WITH_CONDITIONS"), root_1);

                        adaptor.addChild(root_1, stream_columnFamily.nextTree());
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:241:59: ^( CONDITIONS ( getCondition )+ )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITIONS, "CONDITIONS"), root_2);

                        if ( !(stream_getCondition.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_getCondition.hasNext() ) {
                            adaptor.addChild(root_2, stream_getCondition.nextTree());

                        }
                        stream_getCondition.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:241:87: ( ^( NODE_LIMIT $limit) )*
                        while ( stream_limit.hasNext() ) {
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:241:87: ^( NODE_LIMIT $limit)
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIMIT, "NODE_LIMIT"), root_2);

                            adaptor.addChild(root_2, stream_limit.nextNode());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_limit.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getStatement"

    public static class getCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getCondition"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:244:1: getCondition : columnOrSuperColumn operator value -> ^( CONDITION operator columnOrSuperColumn value ) ;
    public final CliParser.getCondition_return getCondition() throws RecognitionException {
        CliParser.getCondition_return retval = new CliParser.getCondition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.columnOrSuperColumn_return columnOrSuperColumn119 = null;

        CliParser.operator_return operator120 = null;

        CliParser.value_return value121 = null;


        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_columnOrSuperColumn=new RewriteRuleSubtreeStream(adaptor,"rule columnOrSuperColumn");
        RewriteRuleSubtreeStream stream_operator=new RewriteRuleSubtreeStream(adaptor,"rule operator");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:245:5: ( columnOrSuperColumn operator value -> ^( CONDITION operator columnOrSuperColumn value ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:245:7: columnOrSuperColumn operator value
            {
            pushFollow(FOLLOW_columnOrSuperColumn_in_getCondition1657);
            columnOrSuperColumn119=columnOrSuperColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(columnOrSuperColumn119.getTree());
            pushFollow(FOLLOW_operator_in_getCondition1659);
            operator120=operator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operator.add(operator120.getTree());
            pushFollow(FOLLOW_value_in_getCondition1661);
            value121=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value121.getTree());


            // AST REWRITE
            // elements: columnOrSuperColumn, operator, value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 246:9: -> ^( CONDITION operator columnOrSuperColumn value )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:246:12: ^( CONDITION operator columnOrSuperColumn value )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITION, "CONDITION"), root_1);

                adaptor.addChild(root_1, stream_operator.nextTree());
                adaptor.addChild(root_1, stream_columnOrSuperColumn.nextTree());
                adaptor.addChild(root_1, stream_value.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getCondition"

    public static class operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operator"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:249:1: operator : ( '=' | '>' | '<' | '>=' | '<=' );
    public final CliParser.operator_return operator() throws RecognitionException {
        CliParser.operator_return retval = new CliParser.operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set122=null;

        CommonTree set122_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:250:5: ( '=' | '>' | '<' | '>=' | '<=' )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set122=(Token)input.LT(1);
            if ( (input.LA(1)>=104 && input.LA(1)<=108) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set122));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operator"

    public static class typeIdentifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeIdentifier"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:253:1: typeIdentifier : ( Identifier | StringLiteral | IntegerPositiveLiteral );
    public final CliParser.typeIdentifier_return typeIdentifier() throws RecognitionException {
        CliParser.typeIdentifier_return retval = new CliParser.typeIdentifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set123=null;

        CommonTree set123_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:254:5: ( Identifier | StringLiteral | IntegerPositiveLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set123=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerPositiveLiteral && input.LA(1)<=StringLiteral) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set123));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeIdentifier"

    public static class setStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "setStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:257:1: setStatement : SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? ) ;
    public final CliParser.setStatement_return setStatement() throws RecognitionException {
        CliParser.setStatement_return retval = new CliParser.setStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ttlValue=null;
        Token SET124=null;
        Token char_literal126=null;
        Token WITH127=null;
        Token TTL128=null;
        Token char_literal129=null;
        CliParser.value_return objectValue = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr125 = null;


        CommonTree ttlValue_tree=null;
        CommonTree SET124_tree=null;
        CommonTree char_literal126_tree=null;
        CommonTree WITH127_tree=null;
        CommonTree TTL128_tree=null;
        CommonTree char_literal129_tree=null;
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleTokenStream stream_TTL=new RewriteRuleTokenStream(adaptor,"token TTL");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:258:5: ( SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:258:7: SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )?
            {
            SET124=(Token)match(input,SET,FOLLOW_SET_in_setStatement1757); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SET.add(SET124);

            pushFollow(FOLLOW_columnFamilyExpr_in_setStatement1759);
            columnFamilyExpr125=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr125.getTree());
            char_literal126=(Token)match(input,104,FOLLOW_104_in_setStatement1761); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_104.add(char_literal126);

            pushFollow(FOLLOW_value_in_setStatement1765);
            objectValue=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(objectValue.getTree());
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:258:50: ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==WITH) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:258:51: WITH TTL '=' ttlValue= IntegerPositiveLiteral
                    {
                    WITH127=(Token)match(input,WITH,FOLLOW_WITH_in_setStatement1768); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WITH.add(WITH127);

                    TTL128=(Token)match(input,TTL,FOLLOW_TTL_in_setStatement1770); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TTL.add(TTL128);

                    char_literal129=(Token)match(input,104,FOLLOW_104_in_setStatement1772); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_104.add(char_literal129);

                    ttlValue=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_setStatement1776); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(ttlValue);


                    }
                    break;

            }



            // AST REWRITE
            // elements: ttlValue, columnFamilyExpr, objectValue
            // token labels: ttlValue
            // rule labels: retval, objectValue
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_ttlValue=new RewriteRuleTokenStream(adaptor,"token ttlValue",ttlValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_objectValue=new RewriteRuleSubtreeStream(adaptor,"rule objectValue",objectValue!=null?objectValue.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 259:9: -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:259:12: ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_SET, "NODE_THRIFT_SET"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                adaptor.addChild(root_1, stream_objectValue.nextTree());
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:259:60: ( $ttlValue)?
                if ( stream_ttlValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_ttlValue.nextNode());

                }
                stream_ttlValue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "setStatement"

    public static class incrStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "incrStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:262:1: incrStatement : ( INCR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? ) | DECR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? ) );
    public final CliParser.incrStatement_return incrStatement() throws RecognitionException {
        CliParser.incrStatement_return retval = new CliParser.incrStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INCR130=null;
        Token BY132=null;
        Token DECR133=null;
        Token BY135=null;
        CliParser.incrementValue_return byValue = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr131 = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr134 = null;


        CommonTree INCR130_tree=null;
        CommonTree BY132_tree=null;
        CommonTree DECR133_tree=null;
        CommonTree BY135_tree=null;
        RewriteRuleTokenStream stream_DECR=new RewriteRuleTokenStream(adaptor,"token DECR");
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_INCR=new RewriteRuleTokenStream(adaptor,"token INCR");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_incrementValue=new RewriteRuleSubtreeStream(adaptor,"rule incrementValue");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:263:5: ( INCR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? ) | DECR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==INCR) ) {
                alt15=1;
            }
            else if ( (LA15_0==DECR) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:263:7: INCR columnFamilyExpr ( BY byValue= incrementValue )?
                    {
                    INCR130=(Token)match(input,INCR,FOLLOW_INCR_in_incrStatement1822); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCR.add(INCR130);

                    pushFollow(FOLLOW_columnFamilyExpr_in_incrStatement1824);
                    columnFamilyExpr131=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr131.getTree());
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:263:29: ( BY byValue= incrementValue )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==BY) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:263:30: BY byValue= incrementValue
                            {
                            BY132=(Token)match(input,BY,FOLLOW_BY_in_incrStatement1827); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY.add(BY132);

                            pushFollow(FOLLOW_incrementValue_in_incrStatement1831);
                            byValue=incrementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_incrementValue.add(byValue.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: byValue, columnFamilyExpr
                    // token labels: 
                    // rule labels: retval, byValue
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_byValue=new RewriteRuleSubtreeStream(adaptor,"rule byValue",byValue!=null?byValue.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 264:9: -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:264:12: ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_INCR, "NODE_THRIFT_INCR"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:264:48: ( $byValue)?
                        if ( stream_byValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_byValue.nextTree());

                        }
                        stream_byValue.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:265:7: DECR columnFamilyExpr ( BY byValue= incrementValue )?
                    {
                    DECR133=(Token)match(input,DECR,FOLLOW_DECR_in_incrStatement1865); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DECR.add(DECR133);

                    pushFollow(FOLLOW_columnFamilyExpr_in_incrStatement1867);
                    columnFamilyExpr134=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr134.getTree());
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:265:29: ( BY byValue= incrementValue )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==BY) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:265:30: BY byValue= incrementValue
                            {
                            BY135=(Token)match(input,BY,FOLLOW_BY_in_incrStatement1870); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY.add(BY135);

                            pushFollow(FOLLOW_incrementValue_in_incrStatement1874);
                            byValue=incrementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_incrementValue.add(byValue.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: byValue, columnFamilyExpr
                    // token labels: 
                    // rule labels: retval, byValue
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_byValue=new RewriteRuleSubtreeStream(adaptor,"rule byValue",byValue!=null?byValue.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 266:9: -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? )
                    {
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:266:12: ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_DECR, "NODE_THRIFT_DECR"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:266:48: ( $byValue)?
                        if ( stream_byValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_byValue.nextTree());

                        }
                        stream_byValue.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incrStatement"

    public static class countStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:269:1: countStatement : COUNT columnFamilyExpr -> ^( NODE_THRIFT_COUNT columnFamilyExpr ) ;
    public final CliParser.countStatement_return countStatement() throws RecognitionException {
        CliParser.countStatement_return retval = new CliParser.countStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COUNT136=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr137 = null;


        CommonTree COUNT136_tree=null;
        RewriteRuleTokenStream stream_COUNT=new RewriteRuleTokenStream(adaptor,"token COUNT");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:270:5: ( COUNT columnFamilyExpr -> ^( NODE_THRIFT_COUNT columnFamilyExpr ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:270:7: COUNT columnFamilyExpr
            {
            COUNT136=(Token)match(input,COUNT,FOLLOW_COUNT_in_countStatement1917); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COUNT.add(COUNT136);

            pushFollow(FOLLOW_columnFamilyExpr_in_countStatement1919);
            columnFamilyExpr137=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr137.getTree());


            // AST REWRITE
            // elements: columnFamilyExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 271:9: -> ^( NODE_THRIFT_COUNT columnFamilyExpr )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:271:12: ^( NODE_THRIFT_COUNT columnFamilyExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_COUNT, "NODE_THRIFT_COUNT"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "countStatement"

    public static class delStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:274:1: delStatement : DEL columnFamilyExpr -> ^( NODE_THRIFT_DEL columnFamilyExpr ) ;
    public final CliParser.delStatement_return delStatement() throws RecognitionException {
        CliParser.delStatement_return retval = new CliParser.delStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DEL138=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr139 = null;


        CommonTree DEL138_tree=null;
        RewriteRuleTokenStream stream_DEL=new RewriteRuleTokenStream(adaptor,"token DEL");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:275:5: ( DEL columnFamilyExpr -> ^( NODE_THRIFT_DEL columnFamilyExpr ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:275:7: DEL columnFamilyExpr
            {
            DEL138=(Token)match(input,DEL,FOLLOW_DEL_in_delStatement1953); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEL.add(DEL138);

            pushFollow(FOLLOW_columnFamilyExpr_in_delStatement1955);
            columnFamilyExpr139=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr139.getTree());


            // AST REWRITE
            // elements: columnFamilyExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 276:9: -> ^( NODE_THRIFT_DEL columnFamilyExpr )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:276:12: ^( NODE_THRIFT_DEL columnFamilyExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_DEL, "NODE_THRIFT_DEL"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delStatement"

    public static class showStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:279:1: showStatement : ( showClusterName | showVersion | showKeyspaces );
    public final CliParser.showStatement_return showStatement() throws RecognitionException {
        CliParser.showStatement_return retval = new CliParser.showStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.showClusterName_return showClusterName140 = null;

        CliParser.showVersion_return showVersion141 = null;

        CliParser.showKeyspaces_return showKeyspaces142 = null;



        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:280:5: ( showClusterName | showVersion | showKeyspaces )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==SHOW) ) {
                switch ( input.LA(2) ) {
                case 100:
                    {
                    alt16=1;
                    }
                    break;
                case API_VERSION:
                    {
                    alt16=2;
                    }
                    break;
                case KEYSPACES:
                    {
                    alt16=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:280:7: showClusterName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showClusterName_in_showStatement1989);
                    showClusterName140=showClusterName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showClusterName140.getTree());

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:281:7: showVersion
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showVersion_in_showStatement1997);
                    showVersion141=showVersion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showVersion141.getTree());

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:282:7: showKeyspaces
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showKeyspaces_in_showStatement2005);
                    showKeyspaces142=showKeyspaces();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showKeyspaces142.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showStatement"

    public static class listStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:285:1: listStatement : LIST columnFamily ( keyRangeExpr )? ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( ^( NODE_LIMIT $limit) )? ) ;
    public final CliParser.listStatement_return listStatement() throws RecognitionException {
        CliParser.listStatement_return retval = new CliParser.listStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token limit=null;
        Token LIST143=null;
        Token string_literal146=null;
        CliParser.columnFamily_return columnFamily144 = null;

        CliParser.keyRangeExpr_return keyRangeExpr145 = null;


        CommonTree limit_tree=null;
        CommonTree LIST143_tree=null;
        CommonTree string_literal146_tree=null;
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_LIST=new RewriteRuleTokenStream(adaptor,"token LIST");
        RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_keyRangeExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyRangeExpr");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:286:5: ( LIST columnFamily ( keyRangeExpr )? ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( ^( NODE_LIMIT $limit) )? ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:286:7: LIST columnFamily ( keyRangeExpr )? ( 'LIMIT' limit= IntegerPositiveLiteral )?
            {
            LIST143=(Token)match(input,LIST,FOLLOW_LIST_in_listStatement2022); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LIST.add(LIST143);

            pushFollow(FOLLOW_columnFamily_in_listStatement2024);
            columnFamily144=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily144.getTree());
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:286:25: ( keyRangeExpr )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==109) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: keyRangeExpr
                    {
                    pushFollow(FOLLOW_keyRangeExpr_in_listStatement2026);
                    keyRangeExpr145=keyRangeExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keyRangeExpr.add(keyRangeExpr145.getTree());

                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:286:39: ( 'LIMIT' limit= IntegerPositiveLiteral )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LIMIT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:286:40: 'LIMIT' limit= IntegerPositiveLiteral
                    {
                    string_literal146=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_listStatement2030); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LIMIT.add(string_literal146);

                    limit=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_listStatement2034); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(limit);


                    }
                    break;

            }



            // AST REWRITE
            // elements: limit, columnFamily, keyRangeExpr
            // token labels: limit
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_limit=new RewriteRuleTokenStream(adaptor,"token limit",limit);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 287:9: -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( ^( NODE_LIMIT $limit) )? )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:287:12: ^( NODE_LIST columnFamily ( keyRangeExpr )? ( ^( NODE_LIMIT $limit) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIST, "NODE_LIST"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:287:37: ( keyRangeExpr )?
                if ( stream_keyRangeExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyRangeExpr.nextTree());

                }
                stream_keyRangeExpr.reset();
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:287:51: ( ^( NODE_LIMIT $limit) )?
                if ( stream_limit.hasNext() ) {
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:287:51: ^( NODE_LIMIT $limit)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIMIT, "NODE_LIMIT"), root_2);

                    adaptor.addChild(root_2, stream_limit.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_limit.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "listStatement"

    public static class truncateStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "truncateStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:290:1: truncateStatement : TRUNCATE columnFamily -> ^( NODE_TRUNCATE columnFamily ) ;
    public final CliParser.truncateStatement_return truncateStatement() throws RecognitionException {
        CliParser.truncateStatement_return retval = new CliParser.truncateStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TRUNCATE147=null;
        CliParser.columnFamily_return columnFamily148 = null;


        CommonTree TRUNCATE147_tree=null;
        RewriteRuleTokenStream stream_TRUNCATE=new RewriteRuleTokenStream(adaptor,"token TRUNCATE");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:291:5: ( TRUNCATE columnFamily -> ^( NODE_TRUNCATE columnFamily ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:291:7: TRUNCATE columnFamily
            {
            TRUNCATE147=(Token)match(input,TRUNCATE,FOLLOW_TRUNCATE_in_truncateStatement2080); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TRUNCATE.add(TRUNCATE147);

            pushFollow(FOLLOW_columnFamily_in_truncateStatement2082);
            columnFamily148=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily148.getTree());


            // AST REWRITE
            // elements: columnFamily
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 292:9: -> ^( NODE_TRUNCATE columnFamily )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:292:12: ^( NODE_TRUNCATE columnFamily )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_TRUNCATE, "NODE_TRUNCATE"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "truncateStatement"

    public static class assumeStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assumeStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:295:1: assumeStatement : ASSUME columnFamily assumptionElement= Identifier 'AS' defaultType= Identifier -> ^( NODE_ASSUME columnFamily $assumptionElement $defaultType) ;
    public final CliParser.assumeStatement_return assumeStatement() throws RecognitionException {
        CliParser.assumeStatement_return retval = new CliParser.assumeStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token assumptionElement=null;
        Token defaultType=null;
        Token ASSUME149=null;
        Token string_literal151=null;
        CliParser.columnFamily_return columnFamily150 = null;


        CommonTree assumptionElement_tree=null;
        CommonTree defaultType_tree=null;
        CommonTree ASSUME149_tree=null;
        CommonTree string_literal151_tree=null;
        RewriteRuleTokenStream stream_ASSUME=new RewriteRuleTokenStream(adaptor,"token ASSUME");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:296:5: ( ASSUME columnFamily assumptionElement= Identifier 'AS' defaultType= Identifier -> ^( NODE_ASSUME columnFamily $assumptionElement $defaultType) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:296:7: ASSUME columnFamily assumptionElement= Identifier 'AS' defaultType= Identifier
            {
            ASSUME149=(Token)match(input,ASSUME,FOLLOW_ASSUME_in_assumeStatement2115); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSUME.add(ASSUME149);

            pushFollow(FOLLOW_columnFamily_in_assumeStatement2117);
            columnFamily150=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily150.getTree());
            assumptionElement=(Token)match(input,Identifier,FOLLOW_Identifier_in_assumeStatement2121); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(assumptionElement);

            string_literal151=(Token)match(input,102,FOLLOW_102_in_assumeStatement2123); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_102.add(string_literal151);

            defaultType=(Token)match(input,Identifier,FOLLOW_Identifier_in_assumeStatement2127); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(defaultType);



            // AST REWRITE
            // elements: assumptionElement, columnFamily, defaultType
            // token labels: defaultType, assumptionElement
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_defaultType=new RewriteRuleTokenStream(adaptor,"token defaultType",defaultType);
            RewriteRuleTokenStream stream_assumptionElement=new RewriteRuleTokenStream(adaptor,"token assumptionElement",assumptionElement);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 297:9: -> ^( NODE_ASSUME columnFamily $assumptionElement $defaultType)
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:297:12: ^( NODE_ASSUME columnFamily $assumptionElement $defaultType)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ASSUME, "NODE_ASSUME"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                adaptor.addChild(root_1, stream_assumptionElement.nextNode());
                adaptor.addChild(root_1, stream_defaultType.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assumeStatement"

    public static class consistencyLevelStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "consistencyLevelStatement"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:300:1: consistencyLevelStatement : CONSISTENCYLEVEL 'AS' defaultType= Identifier -> ^( NODE_CONSISTENCY_LEVEL $defaultType) ;
    public final CliParser.consistencyLevelStatement_return consistencyLevelStatement() throws RecognitionException {
        CliParser.consistencyLevelStatement_return retval = new CliParser.consistencyLevelStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token defaultType=null;
        Token CONSISTENCYLEVEL152=null;
        Token string_literal153=null;

        CommonTree defaultType_tree=null;
        CommonTree CONSISTENCYLEVEL152_tree=null;
        CommonTree string_literal153_tree=null;
        RewriteRuleTokenStream stream_CONSISTENCYLEVEL=new RewriteRuleTokenStream(adaptor,"token CONSISTENCYLEVEL");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:301:5: ( CONSISTENCYLEVEL 'AS' defaultType= Identifier -> ^( NODE_CONSISTENCY_LEVEL $defaultType) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:301:7: CONSISTENCYLEVEL 'AS' defaultType= Identifier
            {
            CONSISTENCYLEVEL152=(Token)match(input,CONSISTENCYLEVEL,FOLLOW_CONSISTENCYLEVEL_in_consistencyLevelStatement2166); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONSISTENCYLEVEL.add(CONSISTENCYLEVEL152);

            string_literal153=(Token)match(input,102,FOLLOW_102_in_consistencyLevelStatement2168); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_102.add(string_literal153);

            defaultType=(Token)match(input,Identifier,FOLLOW_Identifier_in_consistencyLevelStatement2172); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(defaultType);



            // AST REWRITE
            // elements: defaultType
            // token labels: defaultType
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_defaultType=new RewriteRuleTokenStream(adaptor,"token defaultType",defaultType);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 302:9: -> ^( NODE_CONSISTENCY_LEVEL $defaultType)
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:302:12: ^( NODE_CONSISTENCY_LEVEL $defaultType)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONSISTENCY_LEVEL, "NODE_CONSISTENCY_LEVEL"), root_1);

                adaptor.addChild(root_1, stream_defaultType.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "consistencyLevelStatement"

    public static class showClusterName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showClusterName"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:305:1: showClusterName : SHOW 'CLUSTER NAME' -> ^( NODE_SHOW_CLUSTER_NAME ) ;
    public final CliParser.showClusterName_return showClusterName() throws RecognitionException {
        CliParser.showClusterName_return retval = new CliParser.showClusterName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW154=null;
        Token string_literal155=null;

        CommonTree SHOW154_tree=null;
        CommonTree string_literal155_tree=null;
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:306:5: ( SHOW 'CLUSTER NAME' -> ^( NODE_SHOW_CLUSTER_NAME ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:306:7: SHOW 'CLUSTER NAME'
            {
            SHOW154=(Token)match(input,SHOW,FOLLOW_SHOW_in_showClusterName2206); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW154);

            string_literal155=(Token)match(input,100,FOLLOW_100_in_showClusterName2208); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_100.add(string_literal155);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 307:9: -> ^( NODE_SHOW_CLUSTER_NAME )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:307:12: ^( NODE_SHOW_CLUSTER_NAME )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_CLUSTER_NAME, "NODE_SHOW_CLUSTER_NAME"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showClusterName"

    public static class addKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addKeyspace"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:310:1: addKeyspace : CREATE KEYSPACE keyValuePairExpr -> ^( NODE_ADD_KEYSPACE keyValuePairExpr ) ;
    public final CliParser.addKeyspace_return addKeyspace() throws RecognitionException {
        CliParser.addKeyspace_return retval = new CliParser.addKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CREATE156=null;
        Token KEYSPACE157=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr158 = null;


        CommonTree CREATE156_tree=null;
        CommonTree KEYSPACE157_tree=null;
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:311:5: ( CREATE KEYSPACE keyValuePairExpr -> ^( NODE_ADD_KEYSPACE keyValuePairExpr ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:311:7: CREATE KEYSPACE keyValuePairExpr
            {
            CREATE156=(Token)match(input,CREATE,FOLLOW_CREATE_in_addKeyspace2239); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE156);

            KEYSPACE157=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_addKeyspace2241); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE157);

            pushFollow(FOLLOW_keyValuePairExpr_in_addKeyspace2243);
            keyValuePairExpr158=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr158.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 312:9: -> ^( NODE_ADD_KEYSPACE keyValuePairExpr )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:312:12: ^( NODE_ADD_KEYSPACE keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ADD_KEYSPACE, "NODE_ADD_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addKeyspace"

    public static class addColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addColumnFamily"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:315:1: addColumnFamily : CREATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr ) ;
    public final CliParser.addColumnFamily_return addColumnFamily() throws RecognitionException {
        CliParser.addColumnFamily_return retval = new CliParser.addColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CREATE159=null;
        Token COLUMN160=null;
        Token FAMILY161=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr162 = null;


        CommonTree CREATE159_tree=null;
        CommonTree COLUMN160_tree=null;
        CommonTree FAMILY161_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:316:5: ( CREATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:316:7: CREATE COLUMN FAMILY keyValuePairExpr
            {
            CREATE159=(Token)match(input,CREATE,FOLLOW_CREATE_in_addColumnFamily2277); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE159);

            COLUMN160=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_addColumnFamily2279); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN160);

            FAMILY161=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_addColumnFamily2281); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY161);

            pushFollow(FOLLOW_keyValuePairExpr_in_addColumnFamily2283);
            keyValuePairExpr162=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr162.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 317:9: -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:317:12: ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ADD_COLUMN_FAMILY, "NODE_ADD_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addColumnFamily"

    public static class updateKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateKeyspace"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:320:1: updateKeyspace : UPDATE KEYSPACE keyValuePairExpr -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr ) ;
    public final CliParser.updateKeyspace_return updateKeyspace() throws RecognitionException {
        CliParser.updateKeyspace_return retval = new CliParser.updateKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UPDATE163=null;
        Token KEYSPACE164=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr165 = null;


        CommonTree UPDATE163_tree=null;
        CommonTree KEYSPACE164_tree=null;
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:321:5: ( UPDATE KEYSPACE keyValuePairExpr -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:321:7: UPDATE KEYSPACE keyValuePairExpr
            {
            UPDATE163=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateKeyspace2317); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE163);

            KEYSPACE164=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_updateKeyspace2319); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE164);

            pushFollow(FOLLOW_keyValuePairExpr_in_updateKeyspace2321);
            keyValuePairExpr165=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr165.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 322:9: -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:322:12: ^( NODE_UPDATE_KEYSPACE keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_UPDATE_KEYSPACE, "NODE_UPDATE_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "updateKeyspace"

    public static class updateColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateColumnFamily"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:325:1: updateColumnFamily : UPDATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr ) ;
    public final CliParser.updateColumnFamily_return updateColumnFamily() throws RecognitionException {
        CliParser.updateColumnFamily_return retval = new CliParser.updateColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UPDATE166=null;
        Token COLUMN167=null;
        Token FAMILY168=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr169 = null;


        CommonTree UPDATE166_tree=null;
        CommonTree COLUMN167_tree=null;
        CommonTree FAMILY168_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:326:5: ( UPDATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:326:7: UPDATE COLUMN FAMILY keyValuePairExpr
            {
            UPDATE166=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateColumnFamily2354); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE166);

            COLUMN167=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_updateColumnFamily2356); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN167);

            FAMILY168=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_updateColumnFamily2358); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY168);

            pushFollow(FOLLOW_keyValuePairExpr_in_updateColumnFamily2360);
            keyValuePairExpr169=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr169.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 327:9: -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:327:12: ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_UPDATE_COLUMN_FAMILY, "NODE_UPDATE_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "updateColumnFamily"

    public static class delKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delKeyspace"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:330:1: delKeyspace : DROP KEYSPACE keyspace -> ^( NODE_DEL_KEYSPACE keyspace ) ;
    public final CliParser.delKeyspace_return delKeyspace() throws RecognitionException {
        CliParser.delKeyspace_return retval = new CliParser.delKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DROP170=null;
        Token KEYSPACE171=null;
        CliParser.keyspace_return keyspace172 = null;


        CommonTree DROP170_tree=null;
        CommonTree KEYSPACE171_tree=null;
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:331:5: ( DROP KEYSPACE keyspace -> ^( NODE_DEL_KEYSPACE keyspace ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:331:7: DROP KEYSPACE keyspace
            {
            DROP170=(Token)match(input,DROP,FOLLOW_DROP_in_delKeyspace2393); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP170);

            KEYSPACE171=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_delKeyspace2395); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE171);

            pushFollow(FOLLOW_keyspace_in_delKeyspace2397);
            keyspace172=keyspace();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyspace.add(keyspace172.getTree());


            // AST REWRITE
            // elements: keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 332:9: -> ^( NODE_DEL_KEYSPACE keyspace )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:332:12: ^( NODE_DEL_KEYSPACE keyspace )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DEL_KEYSPACE, "NODE_DEL_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyspace.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delKeyspace"

    public static class delColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delColumnFamily"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:335:1: delColumnFamily : DROP COLUMN FAMILY columnFamily -> ^( NODE_DEL_COLUMN_FAMILY columnFamily ) ;
    public final CliParser.delColumnFamily_return delColumnFamily() throws RecognitionException {
        CliParser.delColumnFamily_return retval = new CliParser.delColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DROP173=null;
        Token COLUMN174=null;
        Token FAMILY175=null;
        CliParser.columnFamily_return columnFamily176 = null;


        CommonTree DROP173_tree=null;
        CommonTree COLUMN174_tree=null;
        CommonTree FAMILY175_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:336:5: ( DROP COLUMN FAMILY columnFamily -> ^( NODE_DEL_COLUMN_FAMILY columnFamily ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:336:7: DROP COLUMN FAMILY columnFamily
            {
            DROP173=(Token)match(input,DROP,FOLLOW_DROP_in_delColumnFamily2431); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP173);

            COLUMN174=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_delColumnFamily2433); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN174);

            FAMILY175=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_delColumnFamily2435); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY175);

            pushFollow(FOLLOW_columnFamily_in_delColumnFamily2437);
            columnFamily176=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily176.getTree());


            // AST REWRITE
            // elements: columnFamily
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 337:9: -> ^( NODE_DEL_COLUMN_FAMILY columnFamily )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:337:12: ^( NODE_DEL_COLUMN_FAMILY columnFamily )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DEL_COLUMN_FAMILY, "NODE_DEL_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delColumnFamily"

    public static class showVersion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showVersion"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:340:1: showVersion : SHOW API_VERSION -> ^( NODE_SHOW_VERSION ) ;
    public final CliParser.showVersion_return showVersion() throws RecognitionException {
        CliParser.showVersion_return retval = new CliParser.showVersion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW177=null;
        Token API_VERSION178=null;

        CommonTree SHOW177_tree=null;
        CommonTree API_VERSION178_tree=null;
        RewriteRuleTokenStream stream_API_VERSION=new RewriteRuleTokenStream(adaptor,"token API_VERSION");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:341:5: ( SHOW API_VERSION -> ^( NODE_SHOW_VERSION ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:341:7: SHOW API_VERSION
            {
            SHOW177=(Token)match(input,SHOW,FOLLOW_SHOW_in_showVersion2471); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW177);

            API_VERSION178=(Token)match(input,API_VERSION,FOLLOW_API_VERSION_in_showVersion2473); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_API_VERSION.add(API_VERSION178);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 342:9: -> ^( NODE_SHOW_VERSION )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:342:12: ^( NODE_SHOW_VERSION )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_VERSION, "NODE_SHOW_VERSION"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showVersion"

    public static class showKeyspaces_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showKeyspaces"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:345:1: showKeyspaces : SHOW KEYSPACES -> ^( NODE_SHOW_KEYSPACES ) ;
    public final CliParser.showKeyspaces_return showKeyspaces() throws RecognitionException {
        CliParser.showKeyspaces_return retval = new CliParser.showKeyspaces_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW179=null;
        Token KEYSPACES180=null;

        CommonTree SHOW179_tree=null;
        CommonTree KEYSPACES180_tree=null;
        RewriteRuleTokenStream stream_KEYSPACES=new RewriteRuleTokenStream(adaptor,"token KEYSPACES");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:346:5: ( SHOW KEYSPACES -> ^( NODE_SHOW_KEYSPACES ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:346:7: SHOW KEYSPACES
            {
            SHOW179=(Token)match(input,SHOW,FOLLOW_SHOW_in_showKeyspaces2504); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW179);

            KEYSPACES180=(Token)match(input,KEYSPACES,FOLLOW_KEYSPACES_in_showKeyspaces2506); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACES.add(KEYSPACES180);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 347:9: -> ^( NODE_SHOW_KEYSPACES )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:347:12: ^( NODE_SHOW_KEYSPACES )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_KEYSPACES, "NODE_SHOW_KEYSPACES"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showKeyspaces"

    public static class describeTable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "describeTable"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:350:1: describeTable : DESCRIBE KEYSPACE ( keyspace )? -> ^( NODE_DESCRIBE_TABLE ( keyspace )? ) ;
    public final CliParser.describeTable_return describeTable() throws RecognitionException {
        CliParser.describeTable_return retval = new CliParser.describeTable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESCRIBE181=null;
        Token KEYSPACE182=null;
        CliParser.keyspace_return keyspace183 = null;


        CommonTree DESCRIBE181_tree=null;
        CommonTree KEYSPACE182_tree=null;
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:351:5: ( DESCRIBE KEYSPACE ( keyspace )? -> ^( NODE_DESCRIBE_TABLE ( keyspace )? ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:351:7: DESCRIBE KEYSPACE ( keyspace )?
            {
            DESCRIBE181=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_describeTable2538); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE181);

            KEYSPACE182=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_describeTable2540); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE182);

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:351:25: ( keyspace )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Identifier) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:351:26: keyspace
                    {
                    pushFollow(FOLLOW_keyspace_in_describeTable2543);
                    keyspace183=keyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keyspace.add(keyspace183.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 352:9: -> ^( NODE_DESCRIBE_TABLE ( keyspace )? )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:352:12: ^( NODE_DESCRIBE_TABLE ( keyspace )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DESCRIBE_TABLE, "NODE_DESCRIBE_TABLE"), root_1);

                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:352:34: ( keyspace )?
                if ( stream_keyspace.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyspace.nextTree());

                }
                stream_keyspace.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "describeTable"

    public static class describeCluster_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "describeCluster"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:355:1: describeCluster : DESCRIBE 'CLUSTER' -> ^( NODE_DESCRIBE_CLUSTER ) ;
    public final CliParser.describeCluster_return describeCluster() throws RecognitionException {
        CliParser.describeCluster_return retval = new CliParser.describeCluster_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESCRIBE184=null;
        Token string_literal185=null;

        CommonTree DESCRIBE184_tree=null;
        CommonTree string_literal185_tree=null;
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:356:5: ( DESCRIBE 'CLUSTER' -> ^( NODE_DESCRIBE_CLUSTER ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:356:7: DESCRIBE 'CLUSTER'
            {
            DESCRIBE184=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_describeCluster2585); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE184);

            string_literal185=(Token)match(input,99,FOLLOW_99_in_describeCluster2587); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_99.add(string_literal185);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 357:9: -> ^( NODE_DESCRIBE_CLUSTER )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:357:12: ^( NODE_DESCRIBE_CLUSTER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DESCRIBE_CLUSTER, "NODE_DESCRIBE_CLUSTER"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "describeCluster"

    public static class useKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "useKeyspace"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:360:1: useKeyspace : USE keyspace ( username )? ( password )? -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? ) ;
    public final CliParser.useKeyspace_return useKeyspace() throws RecognitionException {
        CliParser.useKeyspace_return retval = new CliParser.useKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token USE186=null;
        CliParser.keyspace_return keyspace187 = null;

        CliParser.username_return username188 = null;

        CliParser.password_return password189 = null;


        CommonTree USE186_tree=null;
        RewriteRuleTokenStream stream_USE=new RewriteRuleTokenStream(adaptor,"token USE");
        RewriteRuleSubtreeStream stream_username=new RewriteRuleSubtreeStream(adaptor,"rule username");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        RewriteRuleSubtreeStream stream_password=new RewriteRuleSubtreeStream(adaptor,"rule password");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:361:5: ( USE keyspace ( username )? ( password )? -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:361:7: USE keyspace ( username )? ( password )?
            {
            USE186=(Token)match(input,USE,FOLLOW_USE_in_useKeyspace2618); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_USE.add(USE186);

            pushFollow(FOLLOW_keyspace_in_useKeyspace2620);
            keyspace187=keyspace();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyspace.add(keyspace187.getTree());
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:361:20: ( username )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Identifier) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:361:22: username
                    {
                    pushFollow(FOLLOW_username_in_useKeyspace2624);
                    username188=username();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_username.add(username188.getTree());

                    }
                    break;

            }

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:361:34: ( password )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==StringLiteral) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:361:36: password
                    {
                    pushFollow(FOLLOW_password_in_useKeyspace2631);
                    password189=password();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_password.add(password189.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: password, username, keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 362:9: -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:362:12: ^( NODE_USE_TABLE keyspace ( username )? ( password )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_USE_TABLE, "NODE_USE_TABLE"), root_1);

                adaptor.addChild(root_1, stream_keyspace.nextTree());
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:362:38: ( username )?
                if ( stream_username.hasNext() ) {
                    adaptor.addChild(root_1, stream_username.nextTree());

                }
                stream_username.reset();
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:362:52: ( password )?
                if ( stream_password.hasNext() ) {
                    adaptor.addChild(root_1, stream_password.nextTree());

                }
                stream_password.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "useKeyspace"

    public static class keyValuePairExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePairExpr"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:366:1: keyValuePairExpr : objectName ( ( AND | WITH ) keyValuePair )* -> ^( NODE_NEW_KEYSPACE_ACCESS objectName ( keyValuePair )* ) ;
    public final CliParser.keyValuePairExpr_return keyValuePairExpr() throws RecognitionException {
        CliParser.keyValuePairExpr_return retval = new CliParser.keyValuePairExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND191=null;
        Token WITH192=null;
        CliParser.objectName_return objectName190 = null;

        CliParser.keyValuePair_return keyValuePair193 = null;


        CommonTree AND191_tree=null;
        CommonTree WITH192_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_objectName=new RewriteRuleSubtreeStream(adaptor,"rule objectName");
        RewriteRuleSubtreeStream stream_keyValuePair=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePair");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:367:5: ( objectName ( ( AND | WITH ) keyValuePair )* -> ^( NODE_NEW_KEYSPACE_ACCESS objectName ( keyValuePair )* ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:367:7: objectName ( ( AND | WITH ) keyValuePair )*
            {
            pushFollow(FOLLOW_objectName_in_keyValuePairExpr2683);
            objectName190=objectName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_objectName.add(objectName190.getTree());
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:367:18: ( ( AND | WITH ) keyValuePair )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==WITH||LA23_0==AND) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:367:20: ( AND | WITH ) keyValuePair
            	    {
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:367:20: ( AND | WITH )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==AND) ) {
            	        alt22=1;
            	    }
            	    else if ( (LA22_0==WITH) ) {
            	        alt22=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:367:21: AND
            	            {
            	            AND191=(Token)match(input,AND,FOLLOW_AND_in_keyValuePairExpr2688); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_AND.add(AND191);


            	            }
            	            break;
            	        case 2 :
            	            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:367:27: WITH
            	            {
            	            WITH192=(Token)match(input,WITH,FOLLOW_WITH_in_keyValuePairExpr2692); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_WITH.add(WITH192);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_keyValuePair_in_keyValuePairExpr2695);
            	    keyValuePair193=keyValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyValuePair.add(keyValuePair193.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);



            // AST REWRITE
            // elements: objectName, keyValuePair
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 368:9: -> ^( NODE_NEW_KEYSPACE_ACCESS objectName ( keyValuePair )* )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:368:12: ^( NODE_NEW_KEYSPACE_ACCESS objectName ( keyValuePair )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_NEW_KEYSPACE_ACCESS, "NODE_NEW_KEYSPACE_ACCESS"), root_1);

                adaptor.addChild(root_1, stream_objectName.nextTree());
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:368:50: ( keyValuePair )*
                while ( stream_keyValuePair.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyValuePair.nextTree());

                }
                stream_keyValuePair.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyValuePairExpr"

    public static class keyValuePair_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePair"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:371:1: keyValuePair : attr_name '=' attrValue -> attr_name attrValue ;
    public final CliParser.keyValuePair_return keyValuePair() throws RecognitionException {
        CliParser.keyValuePair_return retval = new CliParser.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal195=null;
        CliParser.attr_name_return attr_name194 = null;

        CliParser.attrValue_return attrValue196 = null;


        CommonTree char_literal195_tree=null;
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleSubtreeStream stream_attr_name=new RewriteRuleSubtreeStream(adaptor,"rule attr_name");
        RewriteRuleSubtreeStream stream_attrValue=new RewriteRuleSubtreeStream(adaptor,"rule attrValue");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:372:5: ( attr_name '=' attrValue -> attr_name attrValue )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:372:7: attr_name '=' attrValue
            {
            pushFollow(FOLLOW_attr_name_in_keyValuePair2753);
            attr_name194=attr_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attr_name.add(attr_name194.getTree());
            char_literal195=(Token)match(input,104,FOLLOW_104_in_keyValuePair2755); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_104.add(char_literal195);

            pushFollow(FOLLOW_attrValue_in_keyValuePair2757);
            attrValue196=attrValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attrValue.add(attrValue196.getTree());


            // AST REWRITE
            // elements: attrValue, attr_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 373:6: -> attr_name attrValue
            {
                adaptor.addChild(root_0, stream_attr_name.nextTree());
                adaptor.addChild(root_0, stream_attrValue.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyValuePair"

    public static class attrValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValue"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:376:1: attrValue : ( arrayConstruct | attrValueString | attrValueInt | attrValueDouble );
    public final CliParser.attrValue_return attrValue() throws RecognitionException {
        CliParser.attrValue_return retval = new CliParser.attrValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.arrayConstruct_return arrayConstruct197 = null;

        CliParser.attrValueString_return attrValueString198 = null;

        CliParser.attrValueInt_return attrValueInt199 = null;

        CliParser.attrValueDouble_return attrValueDouble200 = null;



        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:377:5: ( arrayConstruct | attrValueString | attrValueInt | attrValueDouble )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt24=1;
                }
                break;
            case Identifier:
            case StringLiteral:
                {
                alt24=2;
                }
                break;
            case IntegerPositiveLiteral:
            case IntegerNegativeLiteral:
                {
                alt24=3;
                }
                break;
            case DoubleLiteral:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:377:7: arrayConstruct
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayConstruct_in_attrValue2786);
                    arrayConstruct197=arrayConstruct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayConstruct197.getTree());

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:378:7: attrValueString
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueString_in_attrValue2794);
                    attrValueString198=attrValueString();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueString198.getTree());

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:379:7: attrValueInt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueInt_in_attrValue2802);
                    attrValueInt199=attrValueInt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueInt199.getTree());

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:380:7: attrValueDouble
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueDouble_in_attrValue2810);
                    attrValueDouble200=attrValueDouble();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueDouble200.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValue"

    public static class arrayConstruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayConstruct"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:384:1: arrayConstruct : '[' ( hashConstruct ( ',' )? )+ ']' -> ^( ARRAY ( hashConstruct )+ ) ;
    public final CliParser.arrayConstruct_return arrayConstruct() throws RecognitionException {
        CliParser.arrayConstruct_return retval = new CliParser.arrayConstruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal201=null;
        Token char_literal203=null;
        Token char_literal204=null;
        CliParser.hashConstruct_return hashConstruct202 = null;


        CommonTree char_literal201_tree=null;
        CommonTree char_literal203_tree=null;
        CommonTree char_literal204_tree=null;
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleSubtreeStream stream_hashConstruct=new RewriteRuleSubtreeStream(adaptor,"rule hashConstruct");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:385:5: ( '[' ( hashConstruct ( ',' )? )+ ']' -> ^( ARRAY ( hashConstruct )+ ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:385:7: '[' ( hashConstruct ( ',' )? )+ ']'
            {
            char_literal201=(Token)match(input,109,FOLLOW_109_in_arrayConstruct2829); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_109.add(char_literal201);

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:385:11: ( hashConstruct ( ',' )? )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==112) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:385:12: hashConstruct ( ',' )?
            	    {
            	    pushFollow(FOLLOW_hashConstruct_in_arrayConstruct2832);
            	    hashConstruct202=hashConstruct();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_hashConstruct.add(hashConstruct202.getTree());
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:385:26: ( ',' )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==110) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: ','
            	            {
            	            char_literal203=(Token)match(input,110,FOLLOW_110_in_arrayConstruct2834); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_110.add(char_literal203);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            char_literal204=(Token)match(input,111,FOLLOW_111_in_arrayConstruct2839); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_111.add(char_literal204);



            // AST REWRITE
            // elements: hashConstruct
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 386:9: -> ^( ARRAY ( hashConstruct )+ )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:386:12: ^( ARRAY ( hashConstruct )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY, "ARRAY"), root_1);

                if ( !(stream_hashConstruct.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_hashConstruct.hasNext() ) {
                    adaptor.addChild(root_1, stream_hashConstruct.nextTree());

                }
                stream_hashConstruct.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayConstruct"

    public static class hashConstruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hashConstruct"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:389:1: hashConstruct : '{' hashElementPair ( ',' hashElementPair )* '}' -> ^( HASH ( hashElementPair )+ ) ;
    public final CliParser.hashConstruct_return hashConstruct() throws RecognitionException {
        CliParser.hashConstruct_return retval = new CliParser.hashConstruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal205=null;
        Token char_literal207=null;
        Token char_literal209=null;
        CliParser.hashElementPair_return hashElementPair206 = null;

        CliParser.hashElementPair_return hashElementPair208 = null;


        CommonTree char_literal205_tree=null;
        CommonTree char_literal207_tree=null;
        CommonTree char_literal209_tree=null;
        RewriteRuleTokenStream stream_112=new RewriteRuleTokenStream(adaptor,"token 112");
        RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
        RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
        RewriteRuleSubtreeStream stream_hashElementPair=new RewriteRuleSubtreeStream(adaptor,"rule hashElementPair");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:390:5: ( '{' hashElementPair ( ',' hashElementPair )* '}' -> ^( HASH ( hashElementPair )+ ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:390:7: '{' hashElementPair ( ',' hashElementPair )* '}'
            {
            char_literal205=(Token)match(input,112,FOLLOW_112_in_hashConstruct2877); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_112.add(char_literal205);

            pushFollow(FOLLOW_hashElementPair_in_hashConstruct2879);
            hashElementPair206=hashElementPair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_hashElementPair.add(hashElementPair206.getTree());
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:390:27: ( ',' hashElementPair )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==110) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:390:28: ',' hashElementPair
            	    {
            	    char_literal207=(Token)match(input,110,FOLLOW_110_in_hashConstruct2882); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_110.add(char_literal207);

            	    pushFollow(FOLLOW_hashElementPair_in_hashConstruct2884);
            	    hashElementPair208=hashElementPair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_hashElementPair.add(hashElementPair208.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            char_literal209=(Token)match(input,113,FOLLOW_113_in_hashConstruct2888); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_113.add(char_literal209);



            // AST REWRITE
            // elements: hashElementPair
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 391:9: -> ^( HASH ( hashElementPair )+ )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:391:12: ^( HASH ( hashElementPair )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(HASH, "HASH"), root_1);

                if ( !(stream_hashElementPair.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_hashElementPair.hasNext() ) {
                    adaptor.addChild(root_1, stream_hashElementPair.nextTree());

                }
                stream_hashElementPair.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "hashConstruct"

    public static class hashElementPair_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hashElementPair"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:394:1: hashElementPair : rowKey ':' value -> ^( PAIR rowKey value ) ;
    public final CliParser.hashElementPair_return hashElementPair() throws RecognitionException {
        CliParser.hashElementPair_return retval = new CliParser.hashElementPair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal211=null;
        CliParser.rowKey_return rowKey210 = null;

        CliParser.value_return value212 = null;


        CommonTree char_literal211_tree=null;
        RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_rowKey=new RewriteRuleSubtreeStream(adaptor,"rule rowKey");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:5: ( rowKey ':' value -> ^( PAIR rowKey value ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:7: rowKey ':' value
            {
            pushFollow(FOLLOW_rowKey_in_hashElementPair2924);
            rowKey210=rowKey();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowKey.add(rowKey210.getTree());
            char_literal211=(Token)match(input,114,FOLLOW_114_in_hashElementPair2926); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_114.add(char_literal211);

            pushFollow(FOLLOW_value_in_hashElementPair2928);
            value212=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value212.getTree());


            // AST REWRITE
            // elements: rowKey, value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 396:9: -> ^( PAIR rowKey value )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:396:12: ^( PAIR rowKey value )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PAIR, "PAIR"), root_1);

                adaptor.addChild(root_1, stream_rowKey.nextTree());
                adaptor.addChild(root_1, stream_value.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "hashElementPair"

    public static class columnFamilyExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnFamilyExpr"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:399:1: columnFamilyExpr : columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )? -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? ) ;
    public final CliParser.columnFamilyExpr_return columnFamilyExpr() throws RecognitionException {
        CliParser.columnFamilyExpr_return retval = new CliParser.columnFamilyExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal214=null;
        Token char_literal216=null;
        Token char_literal217=null;
        Token char_literal218=null;
        Token char_literal219=null;
        Token char_literal220=null;
        CliParser.columnOrSuperColumn_return column = null;

        CliParser.columnOrSuperColumn_return super_column = null;

        CliParser.columnFamily_return columnFamily213 = null;

        CliParser.rowKey_return rowKey215 = null;


        CommonTree char_literal214_tree=null;
        CommonTree char_literal216_tree=null;
        CommonTree char_literal217_tree=null;
        CommonTree char_literal218_tree=null;
        CommonTree char_literal219_tree=null;
        CommonTree char_literal220_tree=null;
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_rowKey=new RewriteRuleSubtreeStream(adaptor,"rule rowKey");
        RewriteRuleSubtreeStream stream_columnOrSuperColumn=new RewriteRuleSubtreeStream(adaptor,"rule columnOrSuperColumn");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:400:5: ( columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )? -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:400:7: columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )?
            {
            pushFollow(FOLLOW_columnFamily_in_columnFamilyExpr2963);
            columnFamily213=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily213.getTree());
            char_literal214=(Token)match(input,109,FOLLOW_109_in_columnFamilyExpr2965); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_109.add(char_literal214);

            pushFollow(FOLLOW_rowKey_in_columnFamilyExpr2967);
            rowKey215=rowKey();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowKey.add(rowKey215.getTree());
            char_literal216=(Token)match(input,111,FOLLOW_111_in_columnFamilyExpr2969); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_111.add(char_literal216);

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:401:9: ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==109) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:401:11: '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )?
                    {
                    char_literal217=(Token)match(input,109,FOLLOW_109_in_columnFamilyExpr2982); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_109.add(char_literal217);

                    pushFollow(FOLLOW_columnOrSuperColumn_in_columnFamilyExpr2986);
                    column=columnOrSuperColumn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(column.getTree());
                    char_literal218=(Token)match(input,111,FOLLOW_111_in_columnFamilyExpr2988); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_111.add(char_literal218);

                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:402:13: ( '[' super_column= columnOrSuperColumn ']' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==109) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:402:14: '[' super_column= columnOrSuperColumn ']'
                            {
                            char_literal219=(Token)match(input,109,FOLLOW_109_in_columnFamilyExpr3004); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_109.add(char_literal219);

                            pushFollow(FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3008);
                            super_column=columnOrSuperColumn();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(super_column.getTree());
                            char_literal220=(Token)match(input,111,FOLLOW_111_in_columnFamilyExpr3010); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_111.add(char_literal220);


                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: column, super_column, rowKey, columnFamily
            // token labels: 
            // rule labels: retval, column, super_column
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_column=new RewriteRuleSubtreeStream(adaptor,"rule column",column!=null?column.tree:null);
            RewriteRuleSubtreeStream stream_super_column=new RewriteRuleSubtreeStream(adaptor,"rule super_column",super_column!=null?super_column.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 404:7: -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:404:10: ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_COLUMN_ACCESS, "NODE_COLUMN_ACCESS"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                adaptor.addChild(root_1, stream_rowKey.nextTree());
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:404:51: ( $column ( $super_column)? )?
                if ( stream_column.hasNext()||stream_super_column.hasNext() ) {
                    adaptor.addChild(root_1, stream_column.nextTree());
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:404:60: ( $super_column)?
                    if ( stream_super_column.hasNext() ) {
                        adaptor.addChild(root_1, stream_super_column.nextTree());

                    }
                    stream_super_column.reset();

                }
                stream_column.reset();
                stream_super_column.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnFamilyExpr"

    public static class keyRangeExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyRangeExpr"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:407:1: keyRangeExpr : '[' ( ( startKey )? ':' ( endKey )? )? ']' -> ^( NODE_KEY_RANGE ( startKey )? ( endKey )? ) ;
    public final CliParser.keyRangeExpr_return keyRangeExpr() throws RecognitionException {
        CliParser.keyRangeExpr_return retval = new CliParser.keyRangeExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal221=null;
        Token char_literal223=null;
        Token char_literal225=null;
        CliParser.startKey_return startKey222 = null;

        CliParser.endKey_return endKey224 = null;


        CommonTree char_literal221_tree=null;
        CommonTree char_literal223_tree=null;
        CommonTree char_literal225_tree=null;
        RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleSubtreeStream stream_endKey=new RewriteRuleSubtreeStream(adaptor,"rule endKey");
        RewriteRuleSubtreeStream stream_startKey=new RewriteRuleSubtreeStream(adaptor,"rule startKey");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:408:5: ( '[' ( ( startKey )? ':' ( endKey )? )? ']' -> ^( NODE_KEY_RANGE ( startKey )? ( endKey )? ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:408:10: '[' ( ( startKey )? ':' ( endKey )? )? ']'
            {
            char_literal221=(Token)match(input,109,FOLLOW_109_in_keyRangeExpr3073); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_109.add(char_literal221);

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:408:14: ( ( startKey )? ':' ( endKey )? )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=Identifier && LA32_0<=StringLiteral)||LA32_0==114) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:408:16: ( startKey )? ':' ( endKey )?
                    {
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:408:16: ( startKey )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( ((LA30_0>=Identifier && LA30_0<=StringLiteral)) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: startKey
                            {
                            pushFollow(FOLLOW_startKey_in_keyRangeExpr3077);
                            startKey222=startKey();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_startKey.add(startKey222.getTree());

                            }
                            break;

                    }

                    char_literal223=(Token)match(input,114,FOLLOW_114_in_keyRangeExpr3080); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_114.add(char_literal223);

                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:408:30: ( endKey )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=Identifier && LA31_0<=StringLiteral)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: endKey
                            {
                            pushFollow(FOLLOW_endKey_in_keyRangeExpr3082);
                            endKey224=endKey();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_endKey.add(endKey224.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            char_literal225=(Token)match(input,111,FOLLOW_111_in_keyRangeExpr3088); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_111.add(char_literal225);



            // AST REWRITE
            // elements: endKey, startKey
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 409:7: -> ^( NODE_KEY_RANGE ( startKey )? ( endKey )? )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:409:10: ^( NODE_KEY_RANGE ( startKey )? ( endKey )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_KEY_RANGE, "NODE_KEY_RANGE"), root_1);

                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:409:27: ( startKey )?
                if ( stream_startKey.hasNext() ) {
                    adaptor.addChild(root_1, stream_startKey.nextTree());

                }
                stream_startKey.reset();
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:409:37: ( endKey )?
                if ( stream_endKey.hasNext() ) {
                    adaptor.addChild(root_1, stream_endKey.nextTree());

                }
                stream_endKey.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyRangeExpr"

    public static class columnName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnName"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:412:1: columnName : Identifier ;
    public final CliParser.columnName_return columnName() throws RecognitionException {
        CliParser.columnName_return retval = new CliParser.columnName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier226=null;

        CommonTree Identifier226_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:413:2: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:413:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier226=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnName3120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier226_tree = (CommonTree)adaptor.create(Identifier226);
            adaptor.addChild(root_0, Identifier226_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnName"

    public static class attr_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attr_name"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:416:1: attr_name : Identifier ;
    public final CliParser.attr_name_return attr_name() throws RecognitionException {
        CliParser.attr_name_return retval = new CliParser.attr_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier227=null;

        CommonTree Identifier227_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:417:2: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:417:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier227=(Token)match(input,Identifier,FOLLOW_Identifier_in_attr_name3131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier227_tree = (CommonTree)adaptor.create(Identifier227);
            adaptor.addChild(root_0, Identifier227_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attr_name"

    public static class attrValueString_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueString"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:420:1: attrValueString : ( Identifier | StringLiteral ) ;
    public final CliParser.attrValueString_return attrValueString() throws RecognitionException {
        CliParser.attrValueString_return retval = new CliParser.attrValueString_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set228=null;

        CommonTree set228_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:421:2: ( ( Identifier | StringLiteral ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:421:4: ( Identifier | StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            set228=(Token)input.LT(1);
            if ( (input.LA(1)>=Identifier && input.LA(1)<=StringLiteral) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set228));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueString"

    public static class attrValueInt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueInt"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:424:1: attrValueInt : ( IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.attrValueInt_return attrValueInt() throws RecognitionException {
        CliParser.attrValueInt_return retval = new CliParser.attrValueInt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set229=null;

        CommonTree set229_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:425:2: ( IntegerPositiveLiteral | IntegerNegativeLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set229=(Token)input.LT(1);
            if ( input.LA(1)==IntegerPositiveLiteral||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set229));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueInt"

    public static class attrValueDouble_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueDouble"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:429:1: attrValueDouble : DoubleLiteral ;
    public final CliParser.attrValueDouble_return attrValueDouble() throws RecognitionException {
        CliParser.attrValueDouble_return retval = new CliParser.attrValueDouble_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DoubleLiteral230=null;

        CommonTree DoubleLiteral230_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:430:2: ( DoubleLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:430:4: DoubleLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            DoubleLiteral230=(Token)match(input,DoubleLiteral,FOLLOW_DoubleLiteral_in_attrValueDouble3182); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DoubleLiteral230_tree = (CommonTree)adaptor.create(DoubleLiteral230);
            adaptor.addChild(root_0, DoubleLiteral230_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueDouble"

    public static class objectName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectName"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:433:1: objectName : Identifier ;
    public final CliParser.objectName_return objectName() throws RecognitionException {
        CliParser.objectName_return retval = new CliParser.objectName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier231=null;

        CommonTree Identifier231_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:434:2: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:434:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier231=(Token)match(input,Identifier,FOLLOW_Identifier_in_objectName3195); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier231_tree = (CommonTree)adaptor.create(Identifier231);
            adaptor.addChild(root_0, Identifier231_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "objectName"

    public static class keyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyspace"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:437:1: keyspace : Identifier ;
    public final CliParser.keyspace_return keyspace() throws RecognitionException {
        CliParser.keyspace_return retval = new CliParser.keyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier232=null;

        CommonTree Identifier232_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:438:2: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:438:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier232=(Token)match(input,Identifier,FOLLOW_Identifier_in_keyspace3206); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier232_tree = (CommonTree)adaptor.create(Identifier232);
            adaptor.addChild(root_0, Identifier232_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyspace"

    public static class replica_placement_strategy_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replica_placement_strategy"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:441:1: replica_placement_strategy : StringLiteral ;
    public final CliParser.replica_placement_strategy_return replica_placement_strategy() throws RecognitionException {
        CliParser.replica_placement_strategy_return retval = new CliParser.replica_placement_strategy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral233=null;

        CommonTree StringLiteral233_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:442:2: ( StringLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:442:4: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral233=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_replica_placement_strategy3217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral233_tree = (CommonTree)adaptor.create(StringLiteral233);
            adaptor.addChild(root_0, StringLiteral233_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "replica_placement_strategy"

    public static class keyspaceNewName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyspaceNewName"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:445:1: keyspaceNewName : Identifier ;
    public final CliParser.keyspaceNewName_return keyspaceNewName() throws RecognitionException {
        CliParser.keyspaceNewName_return retval = new CliParser.keyspaceNewName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier234=null;

        CommonTree Identifier234_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:446:2: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:446:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier234=(Token)match(input,Identifier,FOLLOW_Identifier_in_keyspaceNewName3228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier234_tree = (CommonTree)adaptor.create(Identifier234);
            adaptor.addChild(root_0, Identifier234_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyspaceNewName"

    public static class comparator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparator"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:449:1: comparator : StringLiteral ;
    public final CliParser.comparator_return comparator() throws RecognitionException {
        CliParser.comparator_return retval = new CliParser.comparator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral235=null;

        CommonTree StringLiteral235_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:450:2: ( StringLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:450:4: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral235=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_comparator3239); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral235_tree = (CommonTree)adaptor.create(StringLiteral235);
            adaptor.addChild(root_0, StringLiteral235_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparator"

    public static class command_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "command"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:453:1: command : Identifier ;
    public final CliParser.command_return command() throws RecognitionException {
        CliParser.command_return retval = new CliParser.command_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier236=null;

        CommonTree Identifier236_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:453:9: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:453:11: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier236=(Token)match(input,Identifier,FOLLOW_Identifier_in_command3255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier236_tree = (CommonTree)adaptor.create(Identifier236);
            adaptor.addChild(root_0, Identifier236_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "command"

    public static class newColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newColumnFamily"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:456:1: newColumnFamily : Identifier ;
    public final CliParser.newColumnFamily_return newColumnFamily() throws RecognitionException {
        CliParser.newColumnFamily_return retval = new CliParser.newColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier237=null;

        CommonTree Identifier237_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:457:2: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:457:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier237=(Token)match(input,Identifier,FOLLOW_Identifier_in_newColumnFamily3266); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier237_tree = (CommonTree)adaptor.create(Identifier237);
            adaptor.addChild(root_0, Identifier237_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "newColumnFamily"

    public static class username_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "username"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:460:1: username : Identifier ;
    public final CliParser.username_return username() throws RecognitionException {
        CliParser.username_return retval = new CliParser.username_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier238=null;

        CommonTree Identifier238_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:460:9: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:460:11: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier238=(Token)match(input,Identifier,FOLLOW_Identifier_in_username3275); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier238_tree = (CommonTree)adaptor.create(Identifier238);
            adaptor.addChild(root_0, Identifier238_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "username"

    public static class password_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "password"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:463:1: password : StringLiteral ;
    public final CliParser.password_return password() throws RecognitionException {
        CliParser.password_return retval = new CliParser.password_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral239=null;

        CommonTree StringLiteral239_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:463:9: ( StringLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:463:11: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral239=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_password3284); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral239_tree = (CommonTree)adaptor.create(StringLiteral239);
            adaptor.addChild(root_0, StringLiteral239_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "password"

    public static class columnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnFamily"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:466:1: columnFamily : Identifier ;
    public final CliParser.columnFamily_return columnFamily() throws RecognitionException {
        CliParser.columnFamily_return retval = new CliParser.columnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier240=null;

        CommonTree Identifier240_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:467:2: ( Identifier )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:467:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier240=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnFamily3295); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier240_tree = (CommonTree)adaptor.create(Identifier240);
            adaptor.addChild(root_0, Identifier240_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnFamily"

    public static class rowKey_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rowKey"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:470:1: rowKey : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall ) ;
    public final CliParser.rowKey_return rowKey() throws RecognitionException {
        CliParser.rowKey_return retval = new CliParser.rowKey_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier241=null;
        Token StringLiteral242=null;
        Token IntegerPositiveLiteral243=null;
        Token IntegerNegativeLiteral244=null;
        CliParser.functionCall_return functionCall245 = null;


        CommonTree Identifier241_tree=null;
        CommonTree StringLiteral242_tree=null;
        CommonTree IntegerPositiveLiteral243_tree=null;
        CommonTree IntegerNegativeLiteral244_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:471:5: ( ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:471:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:471:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall )
            int alt33=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==115) ) {
                    alt33=5;
                }
                else if ( (LA33_1==111||LA33_1==114) ) {
                    alt33=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
                }
                break;
            case StringLiteral:
                {
                alt33=2;
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt33=3;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt33=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:471:9: Identifier
                    {
                    Identifier241=(Token)match(input,Identifier,FOLLOW_Identifier_in_rowKey3312); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier241_tree = (CommonTree)adaptor.create(Identifier241);
                    adaptor.addChild(root_0, Identifier241_tree);
                    }

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:471:22: StringLiteral
                    {
                    StringLiteral242=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_rowKey3316); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral242_tree = (CommonTree)adaptor.create(StringLiteral242);
                    adaptor.addChild(root_0, StringLiteral242_tree);
                    }

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:471:38: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral243=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_rowKey3320); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral243_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral243);
                    adaptor.addChild(root_0, IntegerPositiveLiteral243_tree);
                    }

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:471:63: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral244=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_rowKey3324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral244_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral244);
                    adaptor.addChild(root_0, IntegerNegativeLiteral244_tree);
                    }

                    }
                    break;
                case 5 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:471:88: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_rowKey3328);
                    functionCall245=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall245.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rowKey"

    public static class value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:474:1: value : ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) ;
    public final CliParser.value_return value() throws RecognitionException {
        CliParser.value_return retval = new CliParser.value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier246=null;
        Token IntegerPositiveLiteral247=null;
        Token IntegerNegativeLiteral248=null;
        Token StringLiteral249=null;
        CliParser.functionCall_return functionCall250 = null;


        CommonTree Identifier246_tree=null;
        CommonTree IntegerPositiveLiteral247_tree=null;
        CommonTree IntegerNegativeLiteral248_tree=null;
        CommonTree StringLiteral249_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:475:5: ( ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:475:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:475:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            int alt34=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==115) ) {
                    alt34=5;
                }
                else if ( (LA34_1==EOF||LA34_1==SEMICOLON||LA34_1==WITH||LA34_1==AND||LA34_1==LIMIT||LA34_1==110||LA34_1==113) ) {
                    alt34=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt34=2;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt34=3;
                }
                break;
            case StringLiteral:
                {
                alt34=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:475:8: Identifier
                    {
                    Identifier246=(Token)match(input,Identifier,FOLLOW_Identifier_in_value3345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier246_tree = (CommonTree)adaptor.create(Identifier246);
                    adaptor.addChild(root_0, Identifier246_tree);
                    }

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:475:21: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral247=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_value3349); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral247_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral247);
                    adaptor.addChild(root_0, IntegerPositiveLiteral247_tree);
                    }

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:475:46: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral248=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_value3353); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral248_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral248);
                    adaptor.addChild(root_0, IntegerNegativeLiteral248_tree);
                    }

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:475:71: StringLiteral
                    {
                    StringLiteral249=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_value3357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral249_tree = (CommonTree)adaptor.create(StringLiteral249);
                    adaptor.addChild(root_0, StringLiteral249_tree);
                    }

                    }
                    break;
                case 5 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:475:87: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_value3361);
                    functionCall250=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall250.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "value"

    public static class functionCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:478:1: functionCall : functionName= Identifier '(' ( functionArgument )? ')' -> ^( FUNCTION_CALL $functionName ( functionArgument )? ) ;
    public final CliParser.functionCall_return functionCall() throws RecognitionException {
        CliParser.functionCall_return retval = new CliParser.functionCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token functionName=null;
        Token char_literal251=null;
        Token char_literal253=null;
        CliParser.functionArgument_return functionArgument252 = null;


        CommonTree functionName_tree=null;
        CommonTree char_literal251_tree=null;
        CommonTree char_literal253_tree=null;
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_functionArgument=new RewriteRuleSubtreeStream(adaptor,"rule functionArgument");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:479:5: (functionName= Identifier '(' ( functionArgument )? ')' -> ^( FUNCTION_CALL $functionName ( functionArgument )? ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:479:7: functionName= Identifier '(' ( functionArgument )? ')'
            {
            functionName=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionCall3379); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(functionName);

            char_literal251=(Token)match(input,115,FOLLOW_115_in_functionCall3381); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_115.add(char_literal251);

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:479:35: ( functionArgument )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=IntegerPositiveLiteral && LA35_0<=StringLiteral)||LA35_0==IntegerNegativeLiteral) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: functionArgument
                    {
                    pushFollow(FOLLOW_functionArgument_in_functionCall3383);
                    functionArgument252=functionArgument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionArgument.add(functionArgument252.getTree());

                    }
                    break;

            }

            char_literal253=(Token)match(input,116,FOLLOW_116_in_functionCall3386); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_116.add(char_literal253);



            // AST REWRITE
            // elements: functionName, functionArgument
            // token labels: functionName
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_functionName=new RewriteRuleTokenStream(adaptor,"token functionName",functionName);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 480:9: -> ^( FUNCTION_CALL $functionName ( functionArgument )? )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:480:12: ^( FUNCTION_CALL $functionName ( functionArgument )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);

                adaptor.addChild(root_1, stream_functionName.nextNode());
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:480:42: ( functionArgument )?
                if ( stream_functionArgument.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionArgument.nextTree());

                }
                stream_functionArgument.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class functionArgument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionArgument"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:483:1: functionArgument : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.functionArgument_return functionArgument() throws RecognitionException {
        CliParser.functionArgument_return retval = new CliParser.functionArgument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set254=null;

        CommonTree set254_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:484:5: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set254=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerPositiveLiteral && input.LA(1)<=StringLiteral)||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set254));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionArgument"

    public static class startKey_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "startKey"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:487:1: startKey : ( Identifier | StringLiteral ) ;
    public final CliParser.startKey_return startKey() throws RecognitionException {
        CliParser.startKey_return retval = new CliParser.startKey_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set255=null;

        CommonTree set255_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:488:5: ( ( Identifier | StringLiteral ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:488:7: ( Identifier | StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            set255=(Token)input.LT(1);
            if ( (input.LA(1)>=Identifier && input.LA(1)<=StringLiteral) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set255));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "startKey"

    public static class endKey_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "endKey"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:491:1: endKey : ( Identifier | StringLiteral ) ;
    public final CliParser.endKey_return endKey() throws RecognitionException {
        CliParser.endKey_return retval = new CliParser.endKey_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set256=null;

        CommonTree set256_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:492:5: ( ( Identifier | StringLiteral ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:492:7: ( Identifier | StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            set256=(Token)input.LT(1);
            if ( (input.LA(1)>=Identifier && input.LA(1)<=StringLiteral) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set256));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "endKey"

    public static class columnOrSuperColumn_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnOrSuperColumn"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:495:1: columnOrSuperColumn : ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) ;
    public final CliParser.columnOrSuperColumn_return columnOrSuperColumn() throws RecognitionException {
        CliParser.columnOrSuperColumn_return retval = new CliParser.columnOrSuperColumn_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier257=null;
        Token IntegerPositiveLiteral258=null;
        Token IntegerNegativeLiteral259=null;
        Token StringLiteral260=null;
        CliParser.functionCall_return functionCall261 = null;


        CommonTree Identifier257_tree=null;
        CommonTree IntegerPositiveLiteral258_tree=null;
        CommonTree IntegerNegativeLiteral259_tree=null;
        CommonTree StringLiteral260_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:2: ( ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:4: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:4: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            int alt36=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==115) ) {
                    alt36=5;
                }
                else if ( ((LA36_1>=104 && LA36_1<=108)||LA36_1==111) ) {
                    alt36=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt36=2;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt36=3;
                }
                break;
            case StringLiteral:
                {
                alt36=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:5: Identifier
                    {
                    Identifier257=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnOrSuperColumn3492); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier257_tree = (CommonTree)adaptor.create(Identifier257);
                    adaptor.addChild(root_0, Identifier257_tree);
                    }

                    }
                    break;
                case 2 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:18: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral258=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_columnOrSuperColumn3496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral258_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral258);
                    adaptor.addChild(root_0, IntegerPositiveLiteral258_tree);
                    }

                    }
                    break;
                case 3 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:43: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral259=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_columnOrSuperColumn3500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral259_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral259);
                    adaptor.addChild(root_0, IntegerNegativeLiteral259_tree);
                    }

                    }
                    break;
                case 4 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:68: StringLiteral
                    {
                    StringLiteral260=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_columnOrSuperColumn3504); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral260_tree = (CommonTree)adaptor.create(StringLiteral260);
                    adaptor.addChild(root_0, StringLiteral260_tree);
                    }

                    }
                    break;
                case 5 :
                    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:84: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_columnOrSuperColumn3508);
                    functionCall261=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall261.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnOrSuperColumn"

    public static class host_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "host"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:499:1: host : host_name -> ^( NODE_ID_LIST host_name ) ;
    public final CliParser.host_return host() throws RecognitionException {
        CliParser.host_return retval = new CliParser.host_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.host_name_return host_name262 = null;


        RewriteRuleSubtreeStream stream_host_name=new RewriteRuleSubtreeStream(adaptor,"rule host_name");
        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:500:5: ( host_name -> ^( NODE_ID_LIST host_name ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:500:7: host_name
            {
            pushFollow(FOLLOW_host_name_in_host3524);
            host_name262=host_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_host_name.add(host_name262.getTree());


            // AST REWRITE
            // elements: host_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 501:9: -> ^( NODE_ID_LIST host_name )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:501:12: ^( NODE_ID_LIST host_name )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ID_LIST, "NODE_ID_LIST"), root_1);

                adaptor.addChild(root_1, stream_host_name.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "host"

    public static class host_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "host_name"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:504:1: host_name : Identifier ( '.' Identifier )* ;
    public final CliParser.host_name_return host_name() throws RecognitionException {
        CliParser.host_name_return retval = new CliParser.host_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier263=null;
        Token char_literal264=null;
        Token Identifier265=null;

        CommonTree Identifier263_tree=null;
        CommonTree char_literal264_tree=null;
        CommonTree Identifier265_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:505:2: ( Identifier ( '.' Identifier )* )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:505:4: Identifier ( '.' Identifier )*
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier263=(Token)match(input,Identifier,FOLLOW_Identifier_in_host_name3551); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier263_tree = (CommonTree)adaptor.create(Identifier263);
            adaptor.addChild(root_0, Identifier263_tree);
            }
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:505:15: ( '.' Identifier )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==117) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:505:16: '.' Identifier
            	    {
            	    char_literal264=(Token)match(input,117,FOLLOW_117_in_host_name3554); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal264_tree = (CommonTree)adaptor.create(char_literal264);
            	    adaptor.addChild(root_0, char_literal264_tree);
            	    }
            	    Identifier265=(Token)match(input,Identifier,FOLLOW_Identifier_in_host_name3556); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier265_tree = (CommonTree)adaptor.create(Identifier265);
            	    adaptor.addChild(root_0, Identifier265_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "host_name"

    public static class ip_address_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ip_address"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:508:1: ip_address : IP_ADDRESS -> ^( NODE_ID_LIST IP_ADDRESS ) ;
    public final CliParser.ip_address_return ip_address() throws RecognitionException {
        CliParser.ip_address_return retval = new CliParser.ip_address_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IP_ADDRESS266=null;

        CommonTree IP_ADDRESS266_tree=null;
        RewriteRuleTokenStream stream_IP_ADDRESS=new RewriteRuleTokenStream(adaptor,"token IP_ADDRESS");

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:509:2: ( IP_ADDRESS -> ^( NODE_ID_LIST IP_ADDRESS ) )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:509:4: IP_ADDRESS
            {
            IP_ADDRESS266=(Token)match(input,IP_ADDRESS,FOLLOW_IP_ADDRESS_in_ip_address3570); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IP_ADDRESS.add(IP_ADDRESS266);



            // AST REWRITE
            // elements: IP_ADDRESS
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 510:6: -> ^( NODE_ID_LIST IP_ADDRESS )
            {
                // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:510:9: ^( NODE_ID_LIST IP_ADDRESS )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ID_LIST, "NODE_ID_LIST"), root_1);

                adaptor.addChild(root_1, stream_IP_ADDRESS.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ip_address"

    public static class port_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "port"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:514:1: port : IntegerPositiveLiteral ;
    public final CliParser.port_return port() throws RecognitionException {
        CliParser.port_return retval = new CliParser.port_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IntegerPositiveLiteral267=null;

        CommonTree IntegerPositiveLiteral267_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:5: ( IntegerPositiveLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:7: IntegerPositiveLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            IntegerPositiveLiteral267=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_port3600); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IntegerPositiveLiteral267_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral267);
            adaptor.addChild(root_0, IntegerPositiveLiteral267_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "port"

    public static class incrementValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "incrementValue"
    // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:518:1: incrementValue : ( IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.incrementValue_return incrementValue() throws RecognitionException {
        CliParser.incrementValue_return retval = new CliParser.incrementValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set268=null;

        CommonTree set268_tree=null;

        try {
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:5: ( IntegerPositiveLiteral | IntegerNegativeLiteral )
            // E:\\fuck cassandra\\apache-cassandra-0.8.0-src\\apache-cassandra-0.8.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set268=(Token)input.LT(1);
            if ( input.LA(1)==IntegerPositiveLiteral||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set268));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incrementValue"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA2_eotS =
        "\34\uffff";
    static final String DFA2_eofS =
        "\1\23\33\uffff";
    static final String DFA2_minS =
        "\1\54\3\uffff\4\61\24\uffff";
    static final String DFA2_maxS =
        "\1\145\3\uffff\1\143\3\71\24\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\4\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
        "\1\23\1\24\1\25\1\26\1\27\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13";
    static final String DFA2_specialS =
        "\34\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\23\1\1\1\13\1\10\1\4\1\uffff\2\2\1\16\2\uffff\1\5\1\6\2"+
            "\uffff\1\7\1\12\1\14\2\15\1\11\1\3\1\17\1\20\1\21\1\22\37\uffff"+
            "\1\13",
            "",
            "",
            "",
            "\1\24\61\uffff\1\25",
            "\1\26\7\uffff\1\27",
            "\1\30\7\uffff\1\31",
            "\1\33\7\uffff\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "140:1: statement : ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | -> ^( NODE_NO_OP ) );";
        }
    }
    static final String DFA6_eotS =
        "\43\uffff";
    static final String DFA6_eofS =
        "\1\uffff\1\27\41\uffff";
    static final String DFA6_minS =
        "\1\56\1\54\4\uffff\1\61\2\uffff\1\65\3\61\26\uffff";
    static final String DFA6_maxS =
        "\1\145\1\105\4\uffff\1\143\2\uffff\1\144\3\71\26\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\34\1\1\1\2\1\3\1\uffff\1\6\1\7\4\uffff\1\21\1\22\1\23"+
        "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\4\1\5\1\10\1\11\1\12"+
        "\1\13\1\15\1\14\1\16\1\17\1\20";
    static final String DFA6_specialS =
        "\43\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\66\uffff\1\2",
            "\1\27\1\4\1\3\1\5\1\6\1\uffff\1\7\1\10\1\11\2\uffff\1\12\1"+
            "\13\2\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
            "\1\26",
            "",
            "",
            "",
            "",
            "\1\30\61\uffff\1\31",
            "",
            "",
            "\1\33\1\34\55\uffff\1\32",
            "\1\35\7\uffff\1\36",
            "\1\37\7\uffff\1\40",
            "\1\41\7\uffff\1\42",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "173:1: helpStatement : ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP DESCRIBE KEYSPACE -> ^( NODE_HELP NODE_DESCRIBE_TABLE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) );";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_root407 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_root409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_root412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectStatement_in_statement428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitStatement_in_statement436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStatement_in_statement444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_describeTable_in_statement452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_describeCluster_in_statement460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addKeyspace_in_statement468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addColumnFamily_in_statement476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateKeyspace_in_statement484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateColumnFamily_in_statement492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delColumnFamily_in_statement500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delKeyspace_in_statement508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useKeyspace_in_statement516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delStatement_in_statement524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getStatement_in_statement532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_helpStatement_in_statement540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setStatement_in_statement548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incrStatement_in_statement556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showStatement_in_statement564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listStatement_in_statement572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncateStatement_in_statement580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assumeStatement_in_statement588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_consistencyLevelStatement_in_statement596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONNECT_in_connectStatement625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_host_in_connectStatement627 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_connectStatement629 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_port_in_connectStatement631 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_username_in_connectStatement634 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_password_in_connectStatement636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONNECT_in_connectStatement671 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ip_address_in_connectStatement673 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_connectStatement675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_port_in_connectStatement677 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_username_in_connectStatement680 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_password_in_connectStatement682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement726 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_HELP_in_helpStatement728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement753 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_CONNECT_in_helpStatement755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement780 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_USE_in_helpStatement782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement807 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_DESCRIBE_in_helpStatement809 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement836 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_DESCRIBE_in_helpStatement838 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_helpStatement840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement864 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_EXIT_in_helpStatement866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement891 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_QUIT_in_helpStatement893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement918 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement920 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_helpStatement922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement946 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement948 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYSPACES_in_helpStatement950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement975 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement977 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_API_VERSION_in_helpStatement979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1003 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_CREATE_in_helpStatement1005 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1032 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_UPDATE_in_helpStatement1034 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1060 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_CREATE_in_helpStatement1062 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1064 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1091 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_UPDATE_in_helpStatement1093 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1095 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1121 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_DROP_in_helpStatement1123 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1150 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_DROP_in_helpStatement1152 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1154 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1181 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_GET_in_helpStatement1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1208 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_SET_in_helpStatement1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1235 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_INCR_in_helpStatement1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1261 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_DECR_in_helpStatement1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_DEL_in_helpStatement1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_helpStatement1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1341 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LIST_in_helpStatement1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TRUNCATE_in_helpStatement1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ASSUME_in_helpStatement1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1420 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_CONSISTENCYLEVEL_in_helpStatement1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_helpStatement1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUIT_in_exitStatement1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXIT_in_exitStatement1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getStatement1541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_getStatement1543 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_getStatement1546 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001C0L});
    public static final BitSet FOLLOW_typeIdentifier_in_getStatement1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getStatement1586 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamily_in_getStatement1588 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_getStatement1590 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_getCondition_in_getStatement1592 = new BitSet(new long[]{0x0000000000000002L,0x0000000000041000L});
    public static final BitSet FOLLOW_AND_in_getStatement1595 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_getCondition_in_getStatement1597 = new BitSet(new long[]{0x0000000000000002L,0x0000000000041000L});
    public static final BitSet FOLLOW_LIMIT_in_getStatement1602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_getStatement1606 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_getCondition1657 = new BitSet(new long[]{0x0000000000000000L,0x00001F0000000000L});
    public static final BitSet FOLLOW_operator_in_getCondition1659 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_value_in_getCondition1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeIdentifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_setStatement1757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_setStatement1759 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_setStatement1761 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_value_in_setStatement1765 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_WITH_in_setStatement1768 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_TTL_in_setStatement1770 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_setStatement1772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_setStatement1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCR_in_incrStatement1822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_incrStatement1824 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_BY_in_incrStatement1827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_incrementValue_in_incrStatement1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECR_in_incrStatement1865 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_incrStatement1867 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_BY_in_incrStatement1870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_incrementValue_in_incrStatement1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_countStatement1917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_countStatement1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEL_in_delStatement1953 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_delStatement1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showClusterName_in_showStatement1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showVersion_in_showStatement1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showKeyspaces_in_showStatement2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIST_in_listStatement2022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamily_in_listStatement2024 = new BitSet(new long[]{0x0000000000000002L,0x0000200000040000L});
    public static final BitSet FOLLOW_keyRangeExpr_in_listStatement2026 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_LIMIT_in_listStatement2030 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_listStatement2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUNCATE_in_truncateStatement2080 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamily_in_truncateStatement2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSUME_in_assumeStatement2115 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamily_in_assumeStatement2117 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_assumeStatement2121 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_assumeStatement2123 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_assumeStatement2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSISTENCYLEVEL_in_consistencyLevelStatement2166 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_consistencyLevelStatement2168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_consistencyLevelStatement2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showClusterName2206 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_showClusterName2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_addKeyspace2239 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_addKeyspace2241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_addKeyspace2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_addColumnFamily2277 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_COLUMN_in_addColumnFamily2279 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_FAMILY_in_addColumnFamily2281 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_addColumnFamily2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateKeyspace2317 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_updateKeyspace2319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_updateKeyspace2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateColumnFamily2354 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_COLUMN_in_updateColumnFamily2356 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_FAMILY_in_updateColumnFamily2358 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_updateColumnFamily2360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_delKeyspace2393 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_delKeyspace2395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyspace_in_delKeyspace2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_delColumnFamily2431 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_COLUMN_in_delColumnFamily2433 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_FAMILY_in_delColumnFamily2435 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_columnFamily_in_delColumnFamily2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showVersion2471 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_API_VERSION_in_showVersion2473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showKeyspaces2504 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYSPACES_in_showKeyspaces2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESCRIBE_in_describeTable2538 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_describeTable2540 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyspace_in_describeTable2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESCRIBE_in_describeCluster2585 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_describeCluster2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_useKeyspace2618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyspace_in_useKeyspace2620 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_username_in_useKeyspace2624 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_password_in_useKeyspace2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectName_in_keyValuePairExpr2683 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001200L});
    public static final BitSet FOLLOW_AND_in_keyValuePairExpr2688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_WITH_in_keyValuePairExpr2692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyValuePair_in_keyValuePairExpr2695 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001200L});
    public static final BitSet FOLLOW_attr_name_in_keyValuePair2753 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_keyValuePair2755 = new BitSet(new long[]{0x0000000000000000L,0x00002000000061C0L});
    public static final BitSet FOLLOW_attrValue_in_keyValuePair2757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayConstruct_in_attrValue2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueString_in_attrValue2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueInt_in_attrValue2802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueDouble_in_attrValue2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_arrayConstruct2829 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_hashConstruct_in_arrayConstruct2832 = new BitSet(new long[]{0x0000000000000000L,0x0001C00000000000L});
    public static final BitSet FOLLOW_110_in_arrayConstruct2834 = new BitSet(new long[]{0x0000000000000000L,0x0001800000000000L});
    public static final BitSet FOLLOW_111_in_arrayConstruct2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_hashConstruct2877 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_hashElementPair_in_hashConstruct2879 = new BitSet(new long[]{0x0000000000000000L,0x0002400000000000L});
    public static final BitSet FOLLOW_110_in_hashConstruct2882 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_hashElementPair_in_hashConstruct2884 = new BitSet(new long[]{0x0000000000000000L,0x0002400000000000L});
    public static final BitSet FOLLOW_113_in_hashConstruct2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rowKey_in_hashElementPair2924 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_hashElementPair2926 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_value_in_hashElementPair2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_columnFamily_in_columnFamilyExpr2963 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_columnFamilyExpr2965 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_rowKey_in_columnFamilyExpr2967 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_columnFamilyExpr2969 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_columnFamilyExpr2982 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_columnFamilyExpr2986 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_columnFamilyExpr2988 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_columnFamilyExpr3004 = new BitSet(new long[]{0x0000000000000000L,0x00000000000021C0L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3008 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_columnFamilyExpr3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_keyRangeExpr3073 = new BitSet(new long[]{0x0000000000000000L,0x0004800000000180L});
    public static final BitSet FOLLOW_startKey_in_keyRangeExpr3077 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_keyRangeExpr3080 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000180L});
    public static final BitSet FOLLOW_endKey_in_keyRangeExpr3082 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_keyRangeExpr3088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_columnName3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attr_name3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_attrValueString3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_attrValueInt0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DoubleLiteral_in_attrValueDouble3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_objectName3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_keyspace3206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_replica_placement_strategy3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_keyspaceNewName3228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_comparator3239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_command3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_newColumnFamily3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_username3275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_password3284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_columnFamily3295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_rowKey3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_rowKey3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_rowKey3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_rowKey3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_rowKey3328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_value3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_value3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_value3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_value3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_value3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_functionCall3379 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_functionCall3381 = new BitSet(new long[]{0x0000000000000000L,0x00100000000021C0L});
    public static final BitSet FOLLOW_functionArgument_in_functionCall3383 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_functionCall3386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionArgument0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_startKey3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_endKey3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_columnOrSuperColumn3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_columnOrSuperColumn3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_columnOrSuperColumn3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_columnOrSuperColumn3504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_columnOrSuperColumn3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_host_name_in_host3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_host_name3551 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_host_name3554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_Identifier_in_host_name3556 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
    public static final BitSet FOLLOW_IP_ADDRESS_in_ip_address3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_port3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_incrementValue0 = new BitSet(new long[]{0x0000000000000002L});

}