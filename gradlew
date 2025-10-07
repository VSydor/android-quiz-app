#!/usr/bin/env sh
#
# Gradle start up script for UN*X
#

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

# Add default JVM options here if desired
DEFAULT_JVM_OPTS=""

APP_HOME=$(cd "${0%/*}" && pwd -P)
DEFAULT_JVM_OPTS=${DEFAULT_JVM_OPTS:-"-Xmx64m"}

exec "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" "$@"
