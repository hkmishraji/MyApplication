cmake_minimum_required(VERSION 3.18)
project(MyApplication)

# Use C++17 standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fexceptions -frtti")  # Enable exceptions and RTTI

# Define OpenCV include and lib paths
set(OPENCV_INCLUDE_DIR "C:/Resources/MyApplication/app/OpenCV/native/jni/include/")
set(OPENCV_LIB "C:/Resources/MyApplication/app/src/main/cpp/libs/arm64-v8a/libopencv_java4.so")

# Include OpenCV headers
include_directories(${OPENCV_INCLUDE_DIR})

# Add native library
add_library(
        native-lib       # Name of the library
        SHARED
        native-lib.cpp   # Your source file
)

# Link libraries
target_link_libraries(
        native-lib
        ${OPENCV_LIB}    # OpenCV shared library
        log              # Android log
        c++_shared       # Link C++ runtime for std::string, std::to_string
)
