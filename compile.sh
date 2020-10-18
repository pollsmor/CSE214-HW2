# Compile 1
javac src/applications/arithmetic/*.java 

# Compile 2
javac src/datastructures/sequential/*.java

# Run main method
java src/applications/arithmetic/ArithmeticExpression

# Remove class files that may clog up your explorer window
rm src/applications/arithmetic/*.class
rm src/datastructures/sequential/*.class