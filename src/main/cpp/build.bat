@echo OFF
set CMAKE_C_COMPILER=\msys64\usr\bin\gcc.exe
set CMAKE_CXX_COMPILER=\msys64\usr\bin\gcc.exe
set CMAKE_MAKE_PROGRAM=\msys64\usr\bin\ninja.exe

set PATH=%PATH%;\msys64\usr\bin

\msys64\usr\bin\cmake.exe . -B build/

cd build
\msys64\usr\bin\make.exe 
cd ..