###################################################
# file:		Makefile for homework 5
# 
# This sample Makefile is based on the src + bin folder
# 	organization for your Java programs.  
###################################################
# HOW TO USE THIS MAKEFILE:
#
# 	From any terminal:
# 		> cd $(yourpath_to_hw1)/hw2_Yap	-- go to hw2_Yap folder
# 		> make 				-- this compiles all the Java programs in src.
# 				   All the *.class files will be put
# 				   into a folder called "bin".  If "bin" does
# 				   not exist, it will first create "bin".
# 		> make test		-- this pre-defined test accepts all the defaults 
# 		> make test0	-- this one allows you to override any default
# 		> make testX	-- where X=1,2,3,4,5,6,7
#							are standard tests, with hard coded arguments!
# 							DO NOT CHANGE THEM!
#		> make zip		-- creates hwXXX_YYY.zip for submission
###################################################
#
#  -- Professor Chee Yap
#     Data Structures Course (CS 102)
#
###################################################
# System Setup:  Customize for your own platform (Windows, MacOS, etc)
###################################################
# Who are you?
YYY=LEVENTHAL

# Which homework?
XXX=5

# Java  (I am using Windows with Cygwin)
javaHome=/usr/bin/
# Note: /jdk-11.0.2 links to /cygdrive/c/Program Files/Java/jdk-11.0.2
javac=$(javaHome)/javac
java=$(javaHome)/java

# Editor (My preferred editor is "gvim")


###################################################
# Variables:
###################################################
# program p (you can set this in command line!)
p=Hello
p=List
p=CircList

# default command line arguments (you can set this at command line)
ss=111
nn=10
mm=3
arg0=$(ss)
arg1=$(nn)
arg2=$(mm)
arg3=0
arg4=0
args=$(arg0) $(arg1) $(arg2) $(arg3) $(arg4)

xlint=-Xlint:unchecked -Xlint:deprecation
	
src=src/

###################################################
# Targets:  The first target is always the default target!
###################################################
default: c 

c javac compile: 
	-test -d bin || mkdir bin
	$(javac) $(xlint) -d bin $(src)*.java

r java run: 
	@$(java) -classpath bin ${p} ${args}

r0 java0 run0: 
	@echo "Run with all the defaults"
	@$(java) -classpath bin ${p}

cr: compile run0

# Do you know why we have "@" in front of $(java)? Remove it and see.
h Hello:
	@$(java) -classpath bin Hello ${args}

t test:
	@echo "=================================================="
	@echo "==>test accepts all the default arguments of the Java code:"
	@echo "=================================================="
	@$(java) -classpath bin $(p) 

t0 test0:
	@echo "=================================================="
	@echo "==>test0 allows you to modify any argument in calling 'make'"
	@echo "=================================================="
	@$(java) -classpath bin $(p) ${args}

t1 test1 CircList circ:
	@echo "=================================================="
	@echo "==>test1 is for CircList"
	@echo "=================================================="
	@$(java) -classpath bin CircList 111 8

t2 test2 RhoList rho:
	@echo "=================================================="
	@echo "==>test2 is for RhoList"
	@echo "=================================================="
	@$(java) -classpath bin RhoList 111 10 4

t3 test3 CircListSol:
	@echo "=================================================="
	@echo "==>test3 is for CircListSol"
	@echo "=================================================="
	@$(java) -classpath bin CircListSol 111 8

# NOTE: this test illustrates the recursive call on Makefile!!
t4 test4:
	@echo "=================================================="
	@echo "==>test4 illustrates recursive Makefile "
	@echo "=================================================="
	@make run p=Hello ss=0 

tall testAll: t1 t2 
	@echo "=================================================="
	@echo "==>TESTING t1 and t2"
	@echo "=================================================="

###################################################
# Housekeeping:
###################################################
clean:
	-rm -f -r bin *~ .[^.]* ..?* $(src){*~,.[^.]*,..?*} ioFile

## This is VERY useful for submission of homework!
##		BUT make sure that your set YYY to your own last name.
##		You can submit the zip file found in the parent folder:
zip:	clean
	cd ..; zip hw$(XXX)_$(YYY).zip -r hw$(XXX)_$(YYY)

## This is for us to produce our solution:
zipsol:	clean
	cd ..; zip hw$(XXX)_Sol.zip -r hw$(XXX)_Sol
###################################################
# End
###################################################

