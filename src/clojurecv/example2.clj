;; Example 2


(ns example2
  (:require [clojurecv.simplecv :as cv])
)

;;; load images
(def im1 (cv/load-image "resources/trex_01.png"))
(def im2 (cv/load-image "resources/trex_02.png"))
(def im3 (cv/load-image "resources/trex_03.png"))
(def im4 (cv/load-image "resources/trex_04.png"))

;; show images

(map cv/imshow [im1 im2 im3 im4])

