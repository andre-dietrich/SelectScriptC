.PHONY: all test clean compiler sketch

all: lib antlr
	lein uberjar

install:
	cp target/selectscript-0.1.0-SNAPSHOT-standalone.jar /usr/bin/S2c.jar
	echo "#!/bin/bash" > /usr/bin/S2c
	echo 'java -jar /usr/bin/S2c.jar "$$@"' >> /usr/bin/S2c
	chmod a+x /usr/bin/S2c

uninstall:
	rm -f /usr/bin/S2c.jar
	rm -f /usr/bin/S2c

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
	rm -f hs_err_pid*.log
	rm native/linux-x86-64/libS2.so
	lein clean
	cd SandhillSkipper; make clean
