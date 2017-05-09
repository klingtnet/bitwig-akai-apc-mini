
.PHONY: clean

SCRIPT_DIR:="$$HOME/Bitwig Studio/Controller Scripts"
JAVA_SOURCES:=$(wilcard src/**/*.java)

all: build

build: test $(JAVA_SOURCES) target/APCmini.bwextension	

target/APCmini.bwextension:
	mvn install

test:
	mvn test

install: build
	mkdir -p $(SCRIPT_DIR)
	install -Dm644 target/APCmini.bwextension $(SCRIPT_DIR)

clean:
	rm -rf target
