package db.dbConfig;

import Entity.Customer;
import Entity.Employee;
import Entity.Room;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DbConfig {
    private Customer customer;
    private Employee employee;
    private Room room;

    public DbConfig() {
    }

    public DbConfig(Customer customer) {
        this.customer = customer;
    }

    public DbConfig(Employee employee) {
        this.employee = employee;
    }

    public DbConfig(Room room) {
        this.room = room;
    }

    public boolean saveCustomer() {
        try {
            File file = new File("db/customer-log.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(customer.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveEmployee() {
        try {
            File file = new File("db/employee-log.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(employee.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveRoom() {
        try {
            File file = new File("db/room-log.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(room.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Customer customerfindById(String id) {
        try {
            File file = new File("db/customer-log.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = new Customer();
                customer = customer.parseCustomer(line);
                if (customer.getCustomerId().equals(id)) {
                    return customer;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee employeefindById(String id) {
        try {
            File file = new File("db/employee-log.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Employee employee = new Employee();
                employee = employee.parseEmployee(line);
                if (employee.getEmployeeId().equals(id)) {
                    return employee;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Room roomfindById(String id) {
        try {
            File file = new File("db/room-log.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Room room = new Room();
                room = room.parseRoom(line);
                if (room.getRoomID().equals(id)) {
                    return room;
                }
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Room[] getAllRooms() {
        Room[] rooms = new Room[100];
        int i = 0;
        try {
            File file = new File("db/room-log.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Room room = new Room();
                room = room.parseRoom(line);
                rooms[i] = room;
                i++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Customer[] getAllCustomers() {
        Customer[] customers = new Customer[100];
        int i = 0;
        try {
            File file = new File("db/customer-log.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = new Customer();
                customer = customer.parseCustomer(line);
                customers[i] = customer;
                i++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Employee[] getAllEmployees() {
        Employee[] employees = new Employee[100];
        int i = 0;
        try {
            File file = new File("db/employee-log.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Employee employee = new Employee();
                employee = employee.parseEmployee(line);
                employees[i] = employee;
                i++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public boolean deleteCustomer(String id) {
        try {
            File file = new File("db/customer-log.txt");
            File tempFile = new File("db/temp.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = new Customer();
                customer = customer.parseCustomer(line);
                if (customer.getCustomerId().equals(id)) {
                    continue;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();

            }
            bufferedReader.close();
            bufferedWriter.close();
            Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            tempFile.delete();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployee(String id) {
        try {
            File file = new File("db/employee-log.txt");
            File tempFile = new File("db/temp.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Employee employee = new Employee();
                employee = employee.parseEmployee(line);
                if (employee.getEmployeeId().equals(id)) {
                    continue;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
            Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRoom(String id) {
        try {
            File file = new File("db/room-log.txt");
            File tempFile = new File("db/temp.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Room room = new Room();
                room = room.parseRoom(line);
                if (room.getRoomID().equals(id)) {
                    continue;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();

            }
            bufferedReader.close();
            bufferedWriter.close();
            Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            tempFile.delete();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCustomer() {
        try {
            File file = new File("db/customer-log.txt");
            File tempFile = new File("db/temp.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Customer customer1 = new Customer();
                customer1 = customer1.parseCustomer(line);
                if (customer1.getCustomerId().equals(customer.getCustomerId())) {
                    bufferedWriter.write(customer.toString());
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
            Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            tempFile.delete();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEmployee() {
        try {
            File file = new File("db/employee-log.txt");
            File tempFile = new File("db/temp.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Employee employee1 = new Employee();
                employee1 = employee1.parseEmployee(line);
                if (employee1.getEmployeeId().equals(employee.getEmployeeId())) {
                    bufferedWriter.write(employee.toString());
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }

            bufferedReader.close();
            bufferedWriter.close();
            Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            tempFile.delete();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateRoom() {
        try {
            File file = new File("db/room-log.txt");
            File tempFile = new File("db/temp.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Room room1 = new Room();
                room1 = room1.parseRoom(line);
                if (room1.getRoomID().equals(room.getRoomID())) {
                    bufferedWriter.write(room.toString());
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
            Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            tempFile.delete();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
