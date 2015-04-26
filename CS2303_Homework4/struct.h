#ifndef STRUCT_H
#define STRUCT_H
#define MAX_EMPLOYEE 5
// Define some structures
struct _Employee {
    int salary; // Monthly salary in UK pounds sterling
    char *name; // Pointer to character string holding name of employee.
              // MUST be dynamically allocated from the heap.
    char *dept;
};
// this struct will be used in reading and writing binary files
struct bEmployee{
    char name[100]; // Pointer to character string holding name of employee.
              // MUST be dynamically allocated from the heap.
    char dept[100];
    int salary;
};
typedef struct _Employee Employee; // For convenience

// function prototypes
void printEmployee(Employee *employee);
void outputEmployee(FILE *stream, Employee *employee);
Employee* createEmployee(int salary, char* name, char* dept);
Employee* getEmployeeInfo(int nameSize, int deptSize, int salSize);
int numberOfEmp ();
void writeEmpDataToFile(FILE *stream, Employee *employee);
Employee* employeeInfo(FILE* data);
void readEmpFromBin(int pathname);
void writeEmpDataToBinaryFile(int pathname, Employee *employee);

#endif
