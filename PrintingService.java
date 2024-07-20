/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Printing;
import utils.DbConnection;

public class PrintingService {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static boolean newPrinting(Printing printing) {
        boolean result = false;
        String query = "INSERT INTO printing (type, size, orientation, slides, file, datetime, cost) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbConnection.getDbConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, printing.getType());
            preparedStatement.setString(2, printing.getSize());
            preparedStatement.setString(3, printing.getOrientation());
            preparedStatement.setInt(4, printing.getSlides());
            preparedStatement.setString(5, printing.getFile());
            preparedStatement.setString(6, printing.getDateAndTime());
            preparedStatement.setDouble(7, printing.getCost());

            result = preparedStatement.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static boolean deletePrinting(int id) {
        boolean result = false;

        try {
            connection = DbConnection.getDbConnection();
            String query = "delete  from printing where id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static Printing getPrintingById(int id) {

        Printing printing = null;

        try {
            connection = DbConnection.getDbConnection();
            String query = "select * from printing where id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                printing = new Printing();

                printing.setId(resultSet.getInt("id"));
                printing.setType(resultSet.getString("type"));
                printing.setSize(resultSet.getString("size"));
                printing.setOrientation(resultSet.getString("orientation"));
                printing.setSlides(resultSet.getInt("slides"));
                printing.setFile(resultSet.getString("file"));
                printing.setDateAndTime(resultSet.getString("datetime"));
                printing.setCost(resultSet.getDouble("cost"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return printing;

    }

    public static boolean updatePrinting(Printing printing, int id) {
        boolean result = false;

        try {
            connection = DbConnection.getDbConnection();
            String query = "update printing set type=?, size=?, orientation=?, slides=?, file=?, datetime=?, cost=?  where id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, printing.getType());
            preparedStatement.setString(2, printing.getSize());
            preparedStatement.setString(3, printing.getOrientation());
            preparedStatement.setInt(4, printing.getSlides());
            preparedStatement.setString(5, printing.getFile());
            preparedStatement.setString(6, printing.getDateAndTime());
            preparedStatement.setDouble(7, printing.getCost());
            preparedStatement.setInt(8, id);
            result = preparedStatement.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static List<Printing> getAllPrinting() {
        List<Printing> printings = new ArrayList<Printing>();

        try {
            connection = DbConnection.getDbConnection();
            String query = "select * from printing";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Printing printing = new Printing();

                printing.setId(resultSet.getInt("id"));
                printing.setType(resultSet.getString("type"));
                printing.setSize(resultSet.getString("size"));
                printing.setOrientation(resultSet.getString("orientation"));
                printing.setSlides(resultSet.getInt("slides"));
                printing.setFile(resultSet.getString("file"));
                printing.setDateAndTime(resultSet.getString("datetime"));
                printing.setCost(resultSet.getDouble("cost"));

                printings.add(printing);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return printings;
    }

}
