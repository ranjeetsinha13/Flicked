#!/bin/sh
echo "Running pre -commit checks..."

JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
export JAVA_HOME

OUTPUT="/tmp/res"
./gradlew ktlint lintDebug --daemon > ${OUTPUT}
EXIT_CODE=$?
if [ ${EXIT_CODE} -ne 0 ]; then
    cat ${OUTPUT}
    rm ${OUTPUT}
    echo "Pre Commit Checks Failed. Please fix the above issues before committing"
    exit ${EXIT_CODE}
else
    rm ${OUTPUT}
    echo "Pre Commit Checks Passed -- no problems found"
fi
