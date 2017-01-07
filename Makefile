.PHONY: all test clean compiler sketch

all: lib antlr

lib:
	cd SandhillSkipper; make lib
	cp SandhillSkipper/libS2.so native/linux-x86-64/

antlr:
	cd resources; java -jar ~/.m2/repository/org/antlr/antlr4/4.5.3/antlr4-4.5.3.jar \
	-visitor -no-listener \
	-package S2 \
	-o ../src/antlr/ \
	-long-messages SelectScript.g4

clean:
	cd runtime; make clean
