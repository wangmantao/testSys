steps:
1. 用clj 解析文本，写入一个html文件
2. 原文件以什么形式写，再被读取，然后转写成html形式
    选择题：
	题内容
	选项1	
	选项2	
	选项3	

	--------
	1.建一个记事本，用以上方式写出所有的选择题，然后用写程序把它们解析成html的形式	
	2.分析解析的步骤：
		读取判断该行是否为空行，是设“新题标记”为1,
		解析标题，然后置“新题标记”为0
		读取下行，先
		读取一行：空->"新题标记“ = 1 -读下行
			 不空->可能是题目
				没有”#“号开头
			     ->可能是选项
				有”#“号开头

		具体在clojure中用正则表达式替换成新的字符串
		为以上这些规则建立一个表，记录并完善
3.

