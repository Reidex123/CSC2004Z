.SUFFIXES:    .java   .class
SRCDIR=src
BINDIR=bin
JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

#target: dependency list
#   rule

# everytime a java file in src dir changes, we want to recompile the
# class file with the same name in the bin dir
$(BINDIR)/%.class:  $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

# sorted from least dependent to most dependent
CLASSES=Convertor.class

# string substitutions every item in the CLASSES list that ends with .class is
# going to be replaced with bin/.class, e.g., Source.class becomes
# bin/Source.class
BIN_CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(BIN_CLASS_FILES)

# to clean class files after the compilation is complete.
clean:
	rm $(BINDIR)/*.class

# this rule depends on the class files
run: $(BIN_CLASS_FILES)
	$(JAVA) -cp $(BINDIR) Convertor
