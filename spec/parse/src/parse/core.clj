(ns parse.core
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as s]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn writeResource [name out_path]
  ;; name : io/resource (要导出的)
  ;; path : io/file     (要写入的)
  ;; IO原则： 文件名->io/file -> io/output-stream
           ;; 文件名->io/resource -> io/input-stream
  (let [f (io/file out_path)]
    (with-open [out (io/output-stream f)]
      ;; 用io/copy的形式，把输入流copy到输出流
      (io/copy (io/input-stream (io/resource name)) out)
      f)
      (println "finish!")
))

(defn tes []
  ())
(defn main []
  ;;(writeResource "/home/wmt/test1.txt" "/home/wmt/test.txt")
  ;;(println "hi!"))
  (with-open [rd (io/reader "/home/wmt/test.txt")
              wr (io/writer "/home/wmt/test_new.txt")]
    (io/copy "wang mantao 汉字" wr))
  )


;; 读取原文本一行行读取，一行行解析
#_(
   1. 原文本是以一题为一行，还是其它的什么方式？
      
   2. 所有内容用函数writeResource()
   )
