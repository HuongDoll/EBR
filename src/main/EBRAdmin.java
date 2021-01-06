package main;

import abstractdata.controller.IDataManageController;
import api.inteface.IEBRApiPayment;
import api.payment.EBRPayment;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.ebr.bean.Bike;
import com.ebr.bean.ABike;
import com.ebr.bean.Station;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class EBRAdmin extends JFrame {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;
	public static JLabel titleLabel;
	public static JButton titleButton;
	public static JPanel pagePane;
	public static JButton addBikeButton;

	public EBRAdmin(EBRAdminController controller) {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);
		rootPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());

		titleLabel = new JLabel("Station manager");
		titleButton = new JButton("Add new Station");

		titleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MediaType mediaType = MediaType.parse("application/json");
				RequestBody body = RequestBody.create(mediaType,
						"{\r\n    \"version\" : \"1.0.1\",\r\n    \"transaction\" : {\r\n        \"cardCode\" : \"118609_group8_2020\",\r\n        \"owner\" : \"Group 8\",\r\n        \"cvvCode\" : \"503\",\r\n        \"dateExpired\" : \"1125\",\r\n        \"command\" : \"pay\",\r\n        \"transactionContent\" : \"Thanh toan Mass\",\r\n        \"amount\" : 100,\r\n        \"createdAt\" : \"2020-11-4 10:55:26\"\r\n    },\r\n    \"appCode\" : \"CPyxazieG8U=\",\r\n    \"hashCode\" : \"md5\"\r\n}");

				IEBRApiPayment api = EBRPayment.getInstance();
				api.payment(body);

			}

		});

		titlePanel.add(titleLabel, BorderLayout.WEST);
		titlePanel.add(titleButton, BorderLayout.EAST);

		rootPanel.add(titlePanel, BorderLayout.NORTH);

		pagePane = controller.getStationPage();

		rootPanel.add(pagePane, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EBR for User");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EBRAdmin(new EBRAdminController());
			}
		});
	}
}
