;; Example 1
;; Shows how to load an image and display it on screen
;; It also converts image from RGB to Grayscale and to Lab colorspace

(ns example1
  (:require [clojurecv.simplecv :as cv]))

;; Load image located in resources folder
(def image (cv/load-image "resources/Lenna.png"))

;; Show image on screen
(cv/imshow image "Original")

;; clone image to use it as output matrix
(def output-image (cv/clone-image image))

;; convert image to grayscale
(cv/convert-to-grayscale image output-image)
(cv/imshow output-image "Grayscale")

;; convert image to Lab
(cv/convert-to-lab image output-image)
;; Show grayscale image on screen
(cv/imshow output-image "Lab")

