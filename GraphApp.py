import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np

i=1
if(i==1):
    print(f'{i}');

fig = plt.figure()
ax = fig.add_subplot(111, projection="3d", elev = 0, azim = 49)
ax.set_position([0, 0, 1, 1])

# leer
file = open( "varsGraph.txt")
lineRead = file.readline()
lineFormula = file.readline()
valuesGraph = lineRead.split(",")
valuesForm = lineFormula.split("<")

y = np.linspace(int(valuesGraph[0]),int(valuesGraph[1]),int(valuesGraph[4]))
x= np.linspace(int(valuesGraph[2]),int(valuesGraph[3]),int(valuesGraph[4]))

#Please only modify the Return
def f(x,y):
    return ((x**2)+y**2)

x,y= np.meshgrid(x,y)
h = f(x , y)

# Labels

ax.set_xlabel( " Eje X")
ax.set_ylabel( " Eje Y")
ax.set_zlabel( " Eje Z")

ax.plot_surface(h,x,y, cmap=valuesForm[1])
plt.show()
