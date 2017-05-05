PROGRAMFILES = Main.java Sexpr.java Parser.java Symbolic.java

main: clean $(PROGRAMFILES)
	@javac -Xlint $(PROGRAMFILES)

all: doc main
	@java Main

run: clean main
	@java Main

HashMapDemo: HashMapDemo
	javac HashMapDemo.java
	java HashMapDemo

Parser:	Parser
	javac Parser.java
	java Parser
clear:
	clear; ls

doc: $(PROGRAMFILES)
	javadoc $(PROGRAMFILES)

clean:
	@rm -f *.class *.html *.css package-list *~
	@rm -rf resources
	@echo "All cleaned up!"
# Flymake mode for emacs
# Add the following lines in your .emacs file:
# (require 'flymake)
# (add-hook 'java-mode-hook 'flymake-mode-on)

.PHONY: check-syntax
check-syntax:
	javac -Xlint $(CHK_SOURCES)
