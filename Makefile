.PHONY: all test clean compiler sketch

all: lib antlr
	lein uberjar

install: 
	cp target/selectscript-0.1.0-SNAPSHOT-standalone.jar /usr/local/bin/S2c.jar
	echo "#!/bin/bash" > /usr/local/bin/S2c
	echo 'java -jar /usr/local/bin/S2c.jar "$$@"' >> /usr/local/bin/S2c
	chmod a+x /usr/local/bin/S2c

uninstall:
	rm -f /usr/local/bin/S2c.jar
	rm -f /usr/local/bin/S2c

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
	find . -name "*hs_err_pid*.log" | xargs rm -f
	rm native/linux-x86-64/libS2.so
	lein clean
	cd SandhillSkipper; make clean
