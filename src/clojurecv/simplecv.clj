(ns clojurecv.simplecv
  (:require [clojure.java.io :as io])
  (:import 
   org.opencv.core.Core
   org.opencv.core.Mat
   org.opencv.imgproc.Imgproc
   org.opencv.highgui.Highgui
)


)


;;; Simple utility functions for OpenCV
;;; -----------------------------------

;;; Simple function to load images
(defn load-image [image]
  (Highgui/imread image))

;;; Simple function to write images
(defn write-image [file-name image]
  (Highgui/imwrite file-name image )
)

;;; Clone matrix (useful to quickly create output matrices)
(defn clone-image [image]
  (.clone image)
)

;;; Convert image to grayscale
(defn convert-to-grayscale [source destination]
  (Imgproc/cvtColor source destination Imgproc/COLOR_BGR2GRAY)
)

;;; Convert from RGB to L.a.b
(defn convert-to-lab [source destination]
  (Imgproc/cvtColor source destination Imgproc/COLOR_BGR2Lab)
)

;;; Display image (taken from https://github.com/4gn3s/clojure-opencv/blob/master/src/opencv/viewer.clj)

(defn to-buffered-image [mat]
  (let [out (Mat.)
        colour? (< 1 (.channels mat))
        type (if colour?
               java.awt.image.BufferedImage/TYPE_3BYTE_BGR
               java.awt.image.BufferedImage/TYPE_BYTE_GRAY)
        width (.cols mat)
        height (.rows mat)]
    (do
      (if colour?
        (Imgproc/cvtColor mat out Imgproc/COLOR_BGR2RGB)
        (.copyTo mat out))
      (let [blen (* (.channels mat) width height)
            bytes (byte-array blen)]
        (.get out 0 0 bytes)
        (let [image (java.awt.image.BufferedImage. width height type)
              raster (.getRaster image)]
          (.setDataElements raster 0 0 width height bytes)
          image)))))

(defn show-frame
  [image title]
  (doto (javax.swing.JFrame.)
    (.setTitle title)
    (.add (proxy [javax.swing.JPanel] []
            (paint [g] (.drawImage g image 0 0 nil))))
    (.setSize (java.awt.Dimension. (.getWidth image) (.getHeight image)))
    (.show)))

(defn imshow
  ([mat]
     (imshow mat "Untitled image"))
  ([mat title]
     (show-frame (to-buffered-image mat) title)))

;;; List all files in a directory
 (defn list-files [directory]
   (.list (io/file directory)))

;;; Create list with files in a directory
