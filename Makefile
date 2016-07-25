antlr:
	cd resources; java -jar antlr-4.5.3-complete.jar \
	-visitor -no-listener \
	-package S2 \
	-o ../src/antlr/ \
	-long-messages SelectScript.g4
