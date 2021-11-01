students = ["janneman", "jordan", "john", "jacob", "james"]

for i in range(len(students)):

      if students[i][-1] != 'n' and students[i][1] == 'a':

           print(students[i])

if 35 < 25: 

    print(True)

else: 

    print(False)

name = ['joe', 'soap', 'john', 'doe']

for i in name:

    i.upper()

print(name)



x = (i for i in range(3))

for i in x:

    print(i)

for i in x:

    print(i)


def equate(x,y): 

    return (x**y)/8

ans =equate(2,64)
print(ans)

def factorial(n):

      if n == 1: 

          return n

      else: 

          return n * factorial(n-1)
print(factorial(6))
 
print(str(7 + 4))