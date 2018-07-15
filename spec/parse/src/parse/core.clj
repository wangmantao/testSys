(ns parse.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  ;;(:require [spyscope.core])
  (:require [clojure.string :as s])
  (require  [clojure.tools.trace :as trace]))


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


  (defn indexable-words [text]
    (let [indexable-word? (fn [w] (> (count w) 2))]    ;定义匿名函数, 并绑定给indexable-word?
      (filter indexable-word? (s/split #"\\W+" text))))

(defn a []
  (indexable-words "wangMan")
  )


(defn main []
  ;;(writeResource "/home/wmt/test1.txt" "/home/wmt/test.txt")
  ;;(println "hi!"))
  (println "读取文件打印每一行")
  (with-open [rd (io/reader "/home/wmt/test.txt")]
    (let [contents (line-seq rd)
          order 65]  ;; order 65 -> A
      (println "-----------")
      (doseq [a contents]
        (println a)
        (if (= 0 (.length a))
          (do
            (println "新的一题开始"))
            ;;(println order)(filter (fn [w] (> (count w) 2)) (re-split #"\\W+" "A fine day")) order reset
            ;; 初始化新的变量)
          (do
            (if (s/starts-with? (s/trim a) "#")
              (do
                (let [qStr "&thinsp; <opt>aOrder</opt> oneOption"]
                  ;;(println "有#号的是先项")
                  ;;(println ( s/replace qStr "oneOption" (s/replace-first a "#" "")))
                  (println ( s/replace (s/replace qStr "aOrder" (.toString (char 65))) "oneOption" (s/replace-first a "#" "")))
                  )
                )

              (do
                (let [ qStr "<p>( )<mtxt>qContent</mtxt></p>" ]
                  ;;(println "没#号的是题目")
                  (println ( s/replace qStr "qContent" a))
                  )
                )
              )
            ))))))


  #_(
  (with-open [rd (io/reader "/home/wmt/test.txt")
              wr (io/writer "/home/wmt/test_new.txt")]
    (io/copy "wang mantao 汉字" wr))
  )


;; 读取原文本一行行读取，一行行解析
#_(
   1. 原文本是以一题为一行，还是其它的什么方式？
      
   2. 所有内容用函数writeResource()
   )
