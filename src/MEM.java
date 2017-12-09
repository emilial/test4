import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.EventObject;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MEM extends javax.swing.JFrame {
	  
	static String plik;
	
	public MEM() {
        initComponents(); 
        setVisible(true);
    }

    private void initComponents() {
    	
        komunikat = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        tab = new javax.swing.JTable();        
    	File = new java.lang.String();
    	
// menu Plik
//nowy dodatkowy komentarz   
// i kolejny komentarz tym razem w eclipse
        menuBar = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        nowy = new javax.swing.JMenuItem();
        otworz = new javax.swing.JMenuItem();
        ot = new javax.swing.JMenuItem();
        imp = new javax.swing.JMenu();
        impT = new javax.swing.JMenuItem();
        impH = new javax.swing.JMenuItem();
        impO = new javax.swing.JMenuItem();
        separator1_plik = new javax.swing.JPopupMenu.Separator();
        utr = new javax.swing.JMenu();
        exp = new javax.swing.JMenu();
        expT = new javax.swing.JMenuItem();
        expH = new javax.swing.JMenuItem();
        zap = new javax.swing.JMenuItem();
        zapJ = new javax.swing.JMenuItem();
        zapJako = new javax.swing.JMenuItem();
        zap_pdf = new javax.swing.JMenuItem();
        druk = new javax.swing.JMenuItem();
        separator2_plik = new javax.swing.JPopupMenu.Separator();
        zamk = new javax.swing.JMenuItem();
// menu Edycji    
        menu2 = new javax.swing.JMenu();
        title = new javax.swing.JMenuItem();
        head = new javax.swing.JMenuItem();
        wiersz = new javax.swing.JMenu();
        wiersz_add = new javax.swing.JMenuItem();
        wiersz_min = new javax.swing.JMenuItem();
        kolumna = new javax.swing.JMenu();
        kolumna_add = new javax.swing.JMenuItem();
        kolumna_min = new javax.swing.JMenuItem();
        wstaw = new javax.swing.JMenu();
        w_wzor = new javax.swing.JMenuItem();
        w_obraz = new javax.swing.JMenuItem();
        separator_edit = new javax.swing.JPopupMenu.Separator();
        wyczysc = new javax.swing.JMenuItem();
        wyczyscN = new javax.swing.JMenuItem();
// menu Info
        menu3 = new javax.swing.JMenu();
        pomoc = new javax.swing.JMenuItem();
        separator_info = new javax.swing.JPopupMenu.Separator();
        info = new javax.swing.JMenuItem();
//-------------------------------------------------------------------------------		

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:Edytor tabel MEM:.");
        setBounds(new java.awt.Rectangle(120, 120, 240, 120));

        komunikat.setText("komunikat z ostatniej akcji...");
        getContentPane().add(komunikat, java.awt.BorderLayout.PAGE_END);

        
// tabela
//--------------------------------------------------------------------------------------------
        tytul_tab = " ";	      
        label.setText(" ");
        JScrollPane jScrollPane = new JScrollPane(label);
        JScrollPane jScrollPane2 = new JScrollPane(label);

        tab = new JTable();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        TableFile.readData(getRowCount(), getComponentCount(), File, tytul_tab, columnNames, data);
        tab.setModel(model);
        
        JButton jButton1 = new JButton();

        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportBorder(new LineBorder(Color.BLUE));
        jScrollPane.getViewport().add(jButton1, null);
        jScrollPane.getViewport().add(tab, null);

        getContentPane().add(jScrollPane, BorderLayout.CENTER);
        getContentPane().add(jScrollPane2, BorderLayout.NORTH);        

//------------------------------------------------------------------------------------------- 
// menu Plik
        menu1.setText("Plik");

        nowy.setText("Nowa tabela");
        nowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nowyActionPerformed(evt);
            }
        });
        menu1.add(nowy);
        
        otworz.setText("Otwórz");
        otworz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otworzActionPerformed(evt,"Otwórz tabelę");
            }
        });
        menu1.add(otworz);

        ot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt, String str) {
                otworzActionPerformed(evt,str);
            }

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
        });
        
        imp.setText("Importuj");
        imp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element2ActionPerformed(evt);
            }
        });
        menu1.add(imp);
        
        impT.setText("z Tex");
        impT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importTActionPerformed(evt,"Importuj z formatu Tex");
            }
        });
        imp.add(impT);
        
        impH.setText("z html");
        impH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	element4ActionPerformed(evt);
            }
        });
        imp.add(impH);
        
        impO.setText("z Open Office");
        impO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	element4ActionPerformed(evt);
            }
        });
        imp.add(impO);
        
        menu1.add(separator1_plik);
        
  //------------------------------------------      
        utr.setText("Utrwal");
        utr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element2ActionPerformed(evt);
            }
        });
        menu1.add(utr);
        utr.disable();	      

        exp.setText("Exportuj");
        exp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element2ActionPerformed(evt);
            }
        });
        utr.add(exp);
        
        expT.setText("do Tex");
        expT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	exportTActionPerformed(evt,"Export do Tex");
            }
        });
        exp.add(expT);
        
        expH.setText("do html");
        expH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	element4ActionPerformed(evt);
            }
        });
        exp.add(expH);
        
        zap.setText("Zapisz");
        zap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
    			write.save(plik);
            }
        });
        utr.add(zap);
        
//       zapJ.setText("Zapisz jako ...");
        zapJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt, String str) {
                try {
					zapiszActionPerformed(evt,str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
        });
//        menu1.add(zapJ);
     
        zapJako.setText("Zapisz jako ...");
        zapJako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					zapiszActionPerformed(evt,"Zapisz jako ...");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        utr.add(zapJako);
        
        zap_pdf.setText("Zapisz pdf");
        zap_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {              
					element4ActionPerformed(evt);
            }
        });
        utr.add(zap_pdf);
        
        druk.setText("Drukuj");
        druk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drukActionPerformed(evt, tab);
            }
        });          
        utr.add(druk);
        menu1.add(separator2_plik);

        
        zamk.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        zamk.setText("Zamnkij");
   

        zamk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zamkActionPerformed(evt);
            }
        });
        menu1.add(zamk);
        menuBar.add(menu1);
// koniec menu Plik        
//------------------------------------------------------------------------------------------- 
// menu Edycji
        menu2.setText("Edycja");
     
        title.setText("Edytuj tytuł");
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTActionPerformed(evt);
            }
        });
        menu2.add(title);
        
        head.setText("Edytuj nagłówki");
        head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	editNaglActionPerformed(evt);
            }
        });
        menu2.add(head);
    
        
        wiersz.setText("Wiersz");
        wiersz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element2ActionPerformed(evt);
            }
        });
        menu2.add(wiersz);
        
        wiersz_add.setText("dodaj wiersz");
        wiersz_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_wActionPerformed(evt);
            }
        });
        wiersz.add(wiersz_add);
        
        wiersz_min.setText("usuń wiersz");
        wiersz_min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Del_wActionPerformed(evt);
            }
        });
        wiersz.add(wiersz_min);
     
        
        kolumna.setText("Kolumna");
        kolumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element2ActionPerformed(evt);
            }
        });
        menu2.add(kolumna);
        
        kolumna_add.setText("dodaj kolumnę");
        kolumna_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_kActionPerformed(evt);
            }
        });
        kolumna.add(kolumna_add);
        
        kolumna_min.setText("usuń kolumnę");
        kolumna_min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Del_kActionPerformed(evt);
            }
        });
        kolumna.add(kolumna_min);
        
        
        wstaw.setText("Wstaw");
        wstaw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element2ActionPerformed(evt);
            }
        });
        menu2.add(wstaw);
        
        w_wzor.setText("wzór");
        w_wzor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element4ActionPerformed(evt);
            }
        });
        wstaw.add(w_wzor);
        
        w_obraz.setText("obraz");
        w_obraz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                element4ActionPerformed(evt);
            }
        });
        wstaw.add(w_obraz);
        
        
        wyczysc.setText("Wyczyść tabelę");
        wyczysc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyczyscActionPerformed(evt);
            }
        });
        
        wyczyscN.setText("Wyczyść nagłówki");
        wyczyscN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyczyscNActionPerformed(evt);
            }
        });
        
        menu2.add(separator_edit);
        menu2.add(wyczyscN);
        menu2.add(wyczysc);
        menuBar.add(menu2);
        menu2.disable();
        
// koniec menu Edycji
//------------------------------------------------------------------------------------------- 
// menu Info      
        menu3.setText("Info");
        pomoc.setText("pomoc");
        pomoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        menu3.add(pomoc);
        menu3.add(separator_info);

        info.setText("o Autorze");
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        menu3.add(info);
        menuBar.add(menu3);
        setJMenuBar(menuBar);
// koniec menu Info
//-------------------------------------------------------------------------------------------

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(50, 0, (screenSize.width-200), (screenSize.height-200));
    }// ustawienia położenia i wielkości okna głównego
    
    
    private int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

    public String getName() {
 		return null;
 	} 
    
	private void nowyActionPerformed(java.awt.event.ActionEvent evt) {
        komunikat.setText("tworzenie nowej tabeli");
  	  nowa new_tab = new nowa(new JFrame(), "", "      Utwórz nową tabelę");
      new_tab.setTitle ("Tworzenie nowej tabeli");
		tytul_tab = nowa.tytul.getText();
        komunikat.setText("otwieranie pliku ");
        refresh(tytul_tab);
    }
    
    private void Add_wActionPerformed(java.awt.event.ActionEvent evt) {
        komunikat.setText("dodaj wiersz");
        addW Add_w = new addW(new JFrame(), "", "      Dodaj wiersz");
        Add_w.setTitle ("Dodawanie wierszy");
        Add_w.setSize (200,160);
    }
    
    private void Del_wActionPerformed(java.awt.event.ActionEvent evt) {
        komunikat.setText("usuń wiersz");
        if (tab.getSelectedRow()<0){
          	String disp = "Wybierz wiersz do usunięcia!";
          	JOptionPane.showMessageDialog(null, disp);
        }
        else{ usun Del_w = new usun(new JFrame(), "", "      Usuń wiersz"," ten wiersz","y wiersz");
        Del_w.setTitle ("Usuwanie wierszy");
        Del_w.setSize (350,100);}
    }
    
    private void Add_kActionPerformed(java.awt.event.ActionEvent evt) {
        komunikat.setText("dodaj kolumnę");
        addK Add_k = new addK(new JFrame(), "", "      Dodaj kolumnę");
        Add_k.setTitle ("Dodawanie kolumn");
        Add_k.setSize (200,160);
    }

    private void Del_kActionPerformed(java.awt.event.ActionEvent evt) {
    	komunikat.setText("usuń kolumnę");
        if (tab.getSelectedColumn()<0){
          	String disp = "Wybierz kolumnę do usunięcia!";
          	JOptionPane.showMessageDialog(null, disp);
        }
        else{
        	usun Del_k = new usun(new JFrame(), "", "      Usuń kolumnę"," tę kolumnę","ą kolumnę");
        	Del_k.setTitle ("Usuwanie kolumn");
        	Del_k.setSize (350,100);
        }
    }
    
    
    private void element2ActionPerformed(java.awt.event.ActionEvent evt) {
        komunikat.setText("");
    }

    private void wyczyscActionPerformed(java.awt.event.ActionEvent evt) {
        komunikat.setText("czyszczenie tabeli");  
        wyczysc();
    }
    
    private void wyczyscNActionPerformed(java.awt.event.ActionEvent evt) {
        komunikat.setText("czyszczenie nagłowków");  
        wyczyscN();
    }
    
    private void otworzActionPerformed(java.awt.event.ActionEvent evt, String str2) {
        Frame a = new Frame ("");
        a.setVisible(false);
        FileDialog fd =new FileDialog(a,"Wczytaj",FileDialog.LOAD);
        fd.setTitle(str2);
        fd.setBounds(100,100,400,500);
        fd.setVisible(true);
//        System.out.println(fd.getFile());
        plik = fd.getFile();
        
        model.getDataVector().clear();
        model.setDataVector(tabela.body, tabela.nagl);
        model.fireTableDataChanged();
            
    			try {
    				tabela.file(fd.getFile());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
		    		System.out.println("Nie udana próba wczytania pliku "+fd.getFile());
				}
//				tabela.body[1][2] = "dfgaesgr";
        		tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );
        		tytul_tab = tabela.Tyt;
                komunikat.setText("otwieranie pliku "+fd.getFile());
                refresh(tytul_tab);
    }

    
//czyszczenie zawartości wszystkich komórek w tabeli
    private void wyczysc() {     
        model.getDataVector().clear();
        model.setDataVector(tabela.body, tabela.nagl);
        model.fireTableDataChanged();

        for(int $i = 0; $i<tabela.row; $i++){
            	for(int $j = 0; $j<tabela.columns; $j++){
            		tabela.body[$i][$j] = " ";
            	}
        	}
        tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );
    }
    
  //czyszczenie zawartości wszystkich nagłówków w tabeli    
    private void wyczyscN() {     
        model.getDataVector().clear();
        model.setDataVector(tabela.body, tabela.nagl);
        model.fireTableDataChanged();

            	for(int $j = 0; $j<tabela.columns; $j++){
            		tabela.nagl[$j] = " ";
            	}
        tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );
    }
    
    static void create_newT() {  
        tabela.nagl = new String[nowa.IL_k];
    	tabela.body = new String[nowa.IL_w][nowa.IL_k];
		tabela.row = nowa.IL_w;
		tabela.columns = nowa.IL_k;

        model.getDataVector().clear();
        model.setDataVector(tabela.body, tabela.nagl);
        model.fireTableDataChanged();

        for(int $i = 0; $i<nowa.IL_w; $i++){
            	for(int $j = 0; $j<nowa.IL_k; $j++){
            		tabela.body[$i][$j] = " ";
            	}
        	}
    	for(int $j = 0; $j<nowa.IL_k; $j++){
    		tabela.nagl[$j] = " ";
    	}
        tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );
    }
    
    private void importTActionPerformed(java.awt.event.ActionEvent evt, String str2) {
        Frame a = new Frame ("");
        a.setVisible(false);
        FileDialog fd =new FileDialog(a,"Wczytaj",FileDialog.LOAD);
        fd.setTitle(str2);
        fd.setBounds(100,100,400,500);
        fd.setVisible(true);
//        System.out.println(fd.getFile());
//        plik = fd.getFile();
        try {
			importT.file(fd.getFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    		System.out.println("Nie udana próba wczytania pliku "+fd.getFile());

		}

        plik = fd.getFile();
		String f = plik.replace(".tex", "_impT.MEM");
        plik = f;
		
        model.getDataVector().clear();
        model.setDataVector(tabela.body, tabela.nagl);
        model.fireTableDataChanged();
            
    			try {
    				tabela.file(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
		    		System.out.println("Nie udana próba wczytania pliku "+fd.getFile());
				}
//				tabela.body[1][2] = "dfgaesgr";
        		tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );
        		tytul_tab = tabela.Tyt;
                komunikat.setText("otwieranie pliku "+fd.getFile());
                refresh(tytul_tab);
    }


    private void exportTActionPerformed(java.awt.event.ActionEvent evt, String str2) {
        komunikat.setText("export do Tex");
        Frame a = new Frame ("");
        a.setVisible(false);
        FileDialog fd =new FileDialog(a,"Zapisz",FileDialog.SAVE);
        fd.setTitle(str2);
        fd.setBounds(100,100,400,500);
        fd.setVisible(true);

			writeTex.save(fd.getFile());
    }
        
    private void zapiszActionPerformed(java.awt.event.ActionEvent evt, String str2) throws IOException {
        komunikat.setText("zapisywanie tabeli");
        Frame a = new Frame ("");
        a.setVisible(false);
        FileDialog fd =new FileDialog(a,"Zapisz",FileDialog.SAVE);
        fd.setTitle(str2);
        fd.setBounds(100,100,400,500);
        fd.setVisible(true);

			write.save(fd.getFile());
    }

    private void drukActionPerformed(java.awt.event.ActionEvent evt, javax.swing.JTable tab) {
    	try {
    	    tab.print(PrintMode.FIT_WIDTH, new MessageFormat(tytul_tab), new MessageFormat("Strona {0}"));
    	    }
    	catch (Exception e) {
    	     System.err.println(e);
    	    }
    }
    
    
    private void element4ActionPerformed(java.awt.event.ActionEvent evt) {
        komunikat.setText("ta opcja nie jest jeszcze dostępna");
    }

    private void zamkActionPerformed(java.awt.event.ActionEvent evt) {
    	komunikat.setText("zamknij");
  	  	zamknij dlg = new zamknij(new JFrame(),"","Czy na pewno chcesz zamknąć program MEM ?");
  	  	dlg.setTitle ("Zamykanie aplikacji");
    }

    
    private void editTActionPerformed(java.awt.event.ActionEvent evt) {
        tyt_modyf new_tyt = new tyt_modyf(null, tytul_tab, "");
        tytul_tab = tyt_modyf.tytul.getText();
        new_tyt.setTitle ("Edycja tytułu");
    }
    
    private void editNaglActionPerformed(java.awt.event.ActionEvent evt) {
        nagl_modyf new_nagl = new nagl_modyf(null, "", "");
        refreshNagl(tytul_tab);
        new_nagl.setTitle ("Edycja nagłowków");
    }
    
//odblokowanie opcji edycji i zapisu po wczytaniu tabeli
    void refresh(String e) {    
    	utr.enable();	      
    	menu1.add(utr);
    	menu1.add(separator1_plik);
    	menu1.add(zamk);
    	menuBar.add(menu1);

    	menu2.enable();    
    	menuBar.add(menu2);
     	menuBar.add(menu3);
        setJMenuBar(menuBar);
        label.setText("                            Tytuł tabeli: "+e);
    }
    
    //odświeżenie widoku tytułu
    static void refreshTyt(String e) {    
        label.setText("                            Tytuł tabeli: "+e);
    }
    
    //odswieżenie widoku nagłówków
   static void refreshNagl(String e) {    
        model.getDataVector().clear();
        model.setDataVector(tabela.body, tabela.nagl);
        model.fireTableDataChanged();
 
        for(int $i = 0; $i<tabela.columns; $i++){
			tabela.nagl[$i] = nagl_modyf.nag[$i].getText();
        }
        tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );
    }
   
   public void mouseReleased(MouseEvent e) {
//       System.out.println("" + (tab.getSelectedRow()));
   }
 
  public static void dodaj_w(){
	  
		String B[][] = new String[tabela.row+addW.IL_w][tabela.columns];		
//		System.out.println(add.value);

		int selectedRow = 0;
		if (tab.getSelectedRow()<0) selectedRow = 0;
		else selectedRow = tab.getSelectedRow();
		
		int k =0;
		if (addW.value == 0){
			k=1;
		}
		  // akcja gdy mamy dodać wiersze przed zaznaczonym wierszem
		
			//przepisujemy do nowej tabeli 
        for(int $i=tabela.row+addW.IL_w-1; $i>selectedRow+addW.IL_w-k; $i--){
        	for(int $j = 0; $j<tabela.columns; $j++){
        		B[$i][$j] = tabela.body[$i-addW.IL_w][$j];
        	}
        }

    		if (selectedRow != 0){
            	for(int $i=selectedRow-k; $i>=0; $i--){
            		for(int $j = 0; $j<tabela.columns; $j++){
            			B[$i][$j] = tabela.body[$i][$j];
            		}
            	}	
    		}        	           
	  

	        	tabela.body = new String[tabela.row+addW.IL_w][tabela.columns];
	    		tabela.row = tabela.row+addW.IL_w;

	            model.getDataVector().clear();
	            model.setDataVector(tabela.body, tabela.nagl);
	            model.fireTableDataChanged();

        		tabela.body = B;
		tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );
	            
      }
   
  public static void usun_w(){
	  
		String B[][] = new String[tabela.row-1][tabela.columns];		
		int selectedRow = tab.getSelectedRow();
		
			//przepisujemy do nowej tabeli bez wiesza zaznaczonego do usunięcia
          	for(int $i=selectedRow-1; $i>=0; $i--){
          		for(int $j = 0; $j<tabela.columns; $j++){
          			B[$i][$j] = tabela.body[$i][$j];
          		}
          	}	       	           
	  
            for(int $i=tabela.row-1; $i>selectedRow; $i--){
              	for(int $j = 0; $j<tabela.columns; $j++){
              		B[$i-1][$j] = tabela.body[$i][$j];
              	}
              }
            
	        	tabela.body = new String[tabela.row-1][tabela.columns];
	    		tabela.row = tabela.row-1;

	            model.getDataVector().clear();
	            model.setDataVector(tabela.body, tabela.nagl);
	            model.fireTableDataChanged();

      		tabela.body = B;
		tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );          
    }
  
//  public static void usun_w(){
//	  removeRow(tabela.body[0]);
//  }
  public static void dodaj_k(){
		String B[][] = new String[tabela.row][tabela.columns+addK.IL_k];	
		String A[] = new String[tabela.columns+addK.IL_k];

//		System.out.println(addK.value);

		int selectedColumn = 0;
		if (tab.getSelectedColumn()<0) selectedColumn = 0;
		else selectedColumn = tab.getSelectedColumn();

		int k =0;
		if (addK.value == 0){
			k=1;
		}
		  // akcja gdy mamy dodać wiersze przed zaznaczonym wierszem
		
			//przepisujemy do nowej tabeli 
        for(int $i=tabela.columns+addK.IL_k-1; $i>selectedColumn+addK.IL_k-k; $i--){
        	for(int $j = 0; $j<tabela.row; $j++){
        		B[$j][$i] = tabela.body[$j][$i-addK.IL_k];
            	A[$i]=tabela.nagl[$i-addK.IL_k];
        	}
        }

    		if (selectedColumn != 0){
            	for(int $i=selectedColumn-k; $i>=0; $i--){
            		for(int $j = 0; $j<tabela.row; $j++){
            			B[$j][$i] = tabela.body[$j][$i];
                    	A[$i]=tabela.nagl[$i];
            		}
            	}	
    		}        	           
	  
    		
    		tabela.columns = tabela.columns+addK.IL_k;
	        	tabela.body = new String[tabela.row][tabela.columns];
	        	tabela.nagl = new String[tabela.columns];
//	    		System.out.println("kolumny"+tabela.columns);

	            model.getDataVector().clear();	            
	            model.setDataVector(tabela.body, tabela.nagl);
	            model.fireTableDataChanged();
	            
        		tabela.body = B;        	
        		tabela.nagl = A;
	            
		tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );		
	        }
  
  public static void usun_k(){
	  
		String B[][] = new String[tabela.row][tabela.columns-1];
		String A[] = new String[tabela.columns-1];

		int selectedCol = tab.getSelectedColumn();
		
			//przepisujemy do nowej tabeli bez wiesza zaznaczonego do usunięcia
        	for(int $i=selectedCol-1; $i>=0; $i--){
        		for(int $j = 0; $j<tabela.row; $j++){
        			B[$j][$i] = tabela.body[$j][$i];
        		}
            	A[$i]=tabela.nagl[$i];
        	}	       	           
	  
          for(int $i=tabela.columns-1; $i>selectedCol; $i--){
            	for(int $j = 0; $j<tabela.row; $j++){
            		B[$j][$i-1] = tabela.body[$j][$i];
            	}
            	A[$i-1]=tabela.nagl[$i];
            }
          
	        	tabela.body = new String[tabela.row][tabela.columns-1];
	    		tabela.columns = tabela.columns-1;

	            model.getDataVector().clear();
	            model.setDataVector(tabela.body, tabela.nagl);
	            model.fireTableDataChanged();

    		tabela.body = B;
    		tabela.nagl =A;
		tab.setModel( new DefaultTableModel(tabela.body, tabela.nagl) );          
  }
  
  private void helpActionPerformed(java.awt.event.ActionEvent evt) {
	    komunikat.setText("informacja o działaniu programu");

	  	String disp = "Jest to krótka informacja na temat działania programu do edycji tabel 'MEM'.\n\n"
	  			+ "\nObsługa programu jest na tyle intuicyjna, że nie wymaga komentarza. :)";
	  			
	  			JOptionPane.showMessageDialog(null, disp);
	  }
  
  private void infoActionPerformed(java.awt.event.ActionEvent evt) {
    komunikat.setText("informacja o Autorach programu");

  	String disp = "Jest to krótka informacja na temat programu do edycji tabel 'MEM'.\n\n"
  			+ "\nAutorami programu są Emilia Lubecka oraz Michał Mach,"
  		    + "\nstudenci piątego semestru Niestacjonarnych Studiów Inżynierskich  "
  			+ "\nna Wydziale Eelektroniki Telekomunikacji i Informatyki"
  		    + "\nPolitechniki Gdańskiej, kierunek: Informatyka."
  		    + "\n\n'MEM' jest to program stworzony w ramach projektu z przedmiotu Projekt Grupowy."
  		    + "\nTemat projektu: "
  		    + "\n”Edytor graficzny tabel w środowisku Tex wraz z importem danych z innych formatów”."
  		    + "\nOpiekun projektu: dr inż. Jerzy Dembski"
  		    + "\n\nOpis Projektu:"
  		    + "\nZnaczna pomocą dla osób tworzących dokumentację w środowisku Tex może być "
  		    + "\nprosty graficzny edytor tabel z możliwością dodawania wierszy lub kolumn,"
  		    + "\nwpisywania do nich treści, a także łączenia pól tabeli w poziomie i pionie."
  			+ "\nW projekcie wymagany jest też „inteligentny” import danych do tabeli z innych"
  		    + "\nformatów (np. html, excell). Mile widziana jest możliwość formatowania pól "
  			+ "\ntablicy, a także możliwość korekty w trybie tekstowym.";
  			
  			JOptionPane.showMessageDialog(null, disp);
  }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MEM(); 
            }
        });
    }

    
    //deklaracje zmiennych
    private java.lang.String File;
    
// deklaracje zmiennych

    private javax.swing.JLabel komunikat;
    static javax.swing.JLabel label;
	static String tytul_tab;
	static javax.swing.JTable tab;
    
// menu Plik
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuItem nowy;
    private javax.swing.JMenuItem otworz;
    private javax.swing.JMenuItem ot;
    private javax.swing.JMenu imp;
    private javax.swing.JMenuItem impT;
    private javax.swing.JMenuItem impH;
    private javax.swing.JMenuItem impO;
    private javax.swing.JPopupMenu.Separator separator1_plik;
    private javax.swing.JMenu exp;
    private javax.swing.JMenu utr;
    private javax.swing.JMenuItem expT;
    private javax.swing.JMenuItem expH;
    private javax.swing.JMenuItem zap;
    private javax.swing.JMenuItem zapJ;
    private javax.swing.JMenuItem zapJako;
    private javax.swing.JMenuItem zap_pdf;
    private javax.swing.JMenuItem druk;
    private javax.swing.JPopupMenu.Separator separator2_plik;
    private javax.swing.JMenuItem zamk;
// menu Edycji
    private javax.swing.JMenu menu2;
    private javax.swing.JMenuItem title;
    private javax.swing.JMenuItem head;
    private javax.swing.JMenu wiersz;
    private javax.swing.JMenuItem wiersz_add;
    private javax.swing.JMenuItem wiersz_min;
    private javax.swing.JMenu kolumna;
    private javax.swing.JMenuItem kolumna_add;
    private javax.swing.JMenuItem kolumna_min;
    private javax.swing.JMenu wstaw;
    private javax.swing.JMenuItem w_wzor;
    private javax.swing.JMenuItem w_obraz; 
    private javax.swing.JPopupMenu.Separator separator_edit;
    private javax.swing.JMenuItem wyczysc;
    private javax.swing.JMenuItem wyczyscN;
// menu Info 
    private javax.swing.JMenu menu3;
    private javax.swing.JMenuItem pomoc;
    private javax.swing.JPopupMenu.Separator separator_info;
    private javax.swing.JMenuItem info;
    
//zmienne do wczytania początkowej tabelki
    static DefaultTableModel model = new DefaultTableModel();
    private final String[] columnNames = {""};
    private final Object[][] data = {
        {""},
    };
// koniec deklaracji zmiennych
}
