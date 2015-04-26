typedef  struct Employees{
        char name[100];
        int birth_year;
        int starting_year;
} Employee;

Employee  *make_employee(char* name , int birth_year, int start_year);
Employee  *make_random_employee();
void printEmployee(Employee *employee);
char* stringGenerator();
Employee** arrPointer(int count);
void printEmployeeStruct(int count, Employee** emp);
Employee** dupEmpArr(Employee** src, int count);
void freeStructPointers(Employee** array, int count);

