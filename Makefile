
.PHONY: clean

SCRIPT_DIR:="$$HOME/Bitwig Studio/Controller Scripts/APCmini"
JAVA_SOURCES:=$(wilcard src/**/*.java)

all: build

build: test $(JAVA_SOURCES)
	mvn package

test:
	mvn test

install: build
	mkdir -p $(SCRIPT_DIR)
	install -Dm644 target/apcmini-0.1.jar $(SCRIPT_DIR)

clean:
	rm -rf target
