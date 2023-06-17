/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package db.models;

import java.util.ArrayList; 

public interface Model<T> {
    public boolean insert();
    public T findOne(int id);
    public ArrayList findAll();
    public boolean delete(int id);
    public boolean update(int id, String senha);
}
