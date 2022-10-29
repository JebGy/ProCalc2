from sympy import *

# First Module --> Read Variables from file
file = open("vars.txt")

line = file.readline()

intervals = 0
forms = " "
cantidad = ['', '3']

while line != '':
    if line.__contains__("<"):
        # Validate Line
        pass
    elif line.__contains__("!"):
        forms = line.split("!")
    else:
        intervals = line.split(",")
        # Create a new Array of Variables
    line = file.readline()
file.close()
# Using Sympy
result = ""
print(forms)

longitudeInterval = len(intervals)
print(longitudeInterval)

if (longitudeInterval == 6):
    x, y, z = symbols('x y z')
    result = integrate(forms[1], (x, intervals[0], intervals[1]), (z, intervals[2], intervals[3]),
                       (y, intervals[4], intervals[5]))
if (longitudeInterval == 4):
    x, y = symbols('x y')
    result = integrate(forms[1], (x, intervals[0], intervals[1]), (y, intervals[2], intervals[3]))
if (longitudeInterval == 2):
    x = symbols('x')
    result = integrate(forms[1], (x, intervals[0], intervals[1]))
print(result)
fileResult = open("result.txt", "w")
fileResult.write(f'Result of this operation is: {result}')
fileResult.close()
