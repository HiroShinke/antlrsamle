

CLASSPATH=target/classes:~/.m2/repository/org/antlr/antlr4-runtime/4.9/antlr4-runtime-4.9.jar


java com.github.hiroshinke.antlrsample.App <<EOF
x=1+2
y=3
x+y
EOF

java com.github.hiroshinke.antlrsample.App <<EOF
x=1+2
y=2+3
z=x+y
EOF

java com.github.hiroshinke.antlrsample.App <<EOF
x=1+2*3
EOF

java com.github.hiroshinke.antlrsample.App <<EOF
x=(1+2)/3
EOF

java com.github.hiroshinke.antlrsample.App <<EOF
x=1-2-3
EOF

java com.github.hiroshinke.antlrsample.App <<EOF
x=2^10 + 2
EOF








