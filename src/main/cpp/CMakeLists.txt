cmake_minimum_required(VERSION 3.10)
project(mymod)

# Set the path to the JDK
set(JDK_PATH "$ENV{JAVA_HOME}")

# Include directories for JNI headers
include_directories("${JDK_PATH}/include")
if (WIN32)
    include_directories("${JDK_PATH}/include/win32")
elseif (APPLE)
    include_directories("${JDK_PATH}/include/darwin")
else ()
    include_directories("${JDK_PATH}/include/linux")
endif ()

# Set the source file
set(SOURCES mymod.cpp)

# Create the shared library
add_library(mymod SHARED ${SOURCES})

# Set the output directory for the shared library
set_target_properties(mymod PROPERTIES
    LIBRARY_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/lib"
)

# Add platform-specific flags
if (WIN32)
    set_target_properties(mymod PROPERTIES PREFIX "")
endif ()
