(ns parse.core
  (:require [clojure.java.io :as io] ))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn writeResource [name path]
  ;; name : io/resource (要导出的)
  ;; path : io/file     (要写入的)
  ;; IO原则： 文件名->io/file -> io/output-stream
           ;; 文件名->io/resource -> io/input-stream
  
  (let [f (io/file path)]
    (with-open [out (io/output-stream f)]
      ;; 用io/copy的形式，把输入流copy到输出流
      io/copy ( (io/input-stream (io/resource name)) out)
)))

(defn main []
  (writeResource "test.txt" "test.txt")
  (println "hi!"))


;; 先用写出一个本地文件
#_(
   1. 用到了IO
   2. 所有内容用函数writeResource()
   )
