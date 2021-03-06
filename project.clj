(defproject clojurecv "0.1.0-SNAPSHOT"
  :description "Simple template for OpenCV in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [opencv/opencv "2.4.13"]
                 [opencv/opencv-native "2.4.13"]
                 [com.cemerick/pomegranate "0.3.1"]
                 ]
  :injections [(clojure.lang.RT/loadLibrary org.opencv.core.Core/NATIVE_LIBRARY_NAME)]
  )

