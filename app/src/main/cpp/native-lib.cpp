#include <jni.h>
#include <string>
#include <opencv2/core.hpp>
#include <opencv2/opencv.hpp>
#include <opencv2/imgproc.hpp>

extern "C"
jstring
Java_com_example_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    cv::Mat mat = cv::Mat::zeros(3, 3, CV_8UC1);
    mat.at<uchar>(0, 0) = 255;

    std::string result = "OpenCV Working! Pixel[0,0] = ";
    result += std::to_string(mat.at<uchar>(0, 0));

    return env->NewStringUTF(result.c_str());
}
