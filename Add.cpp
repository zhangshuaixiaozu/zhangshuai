// Add.cpp : implementation file
//

#include "stdafx.h"
#include "通讯录.h"
#include "Add.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// Add dialog


Add::Add(CWnd* pParent /*=NULL*/)
	: CDialog(Add::IDD, pParent)
{
	//{{AFX_DATA_INIT(Add)
	m_Addname = _T("");
	m_Adddate = _T("");
	m_Addaddress = _T("");
	m_Addsalary = _T("");
	m_Addalimoney = _T("");
	m_Addbonus = _T("");
	//}}AFX_DATA_INIT
}


void Add::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(Add)
	DDX_Control(pDX, IDC_BUTTON1, m_Addsure);
	DDX_Text(pDX, IDC_EDIT1, m_Addname);
	DDX_Text(pDX, IDC_EDIT2, m_Adddate);
	DDX_Text(pDX, IDC_EDIT3, m_Addaddress);
	DDX_Text(pDX, IDC_EDIT4, m_Addsalary);
	DDX_Text(pDX, IDC_EDIT5, m_Addalimoney);
	DDX_Text(pDX, IDC_EDIT6, m_Addbonus);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(Add, CDialog)
	//{{AFX_MSG_MAP(Add)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_EN_CHANGE(IDC_EDIT1, OnAddname)
	ON_BN_CLICKED(IDC_BUTTON2, OnButton2)
	ON_WM_PAINT()
	ON_WM_CTLCOLOR()
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// Add message handlers

void Add::OnButton1() 
{
	// TODO: Add your control notification handler code here
	UpdateData(true);
	
	if(m_Addname==""||m_Adddate==""||m_Addaddress==""||m_Addsalary==""||m_Addbonus==""||m_Addalimoney=="")
	{MessageBox("信息不完整，无法添加！","错误");
	return ;
	}
	CStdioFile file;
	file.Open( "Data.txt ",CFile::modeReadWrite);
	CString split=" ";
	file.SeekToEnd();
	file.WriteString("\n");
	file.WriteString(m_Addname);
	file.WriteString(split);
	file.WriteString(m_Adddate);
	file.WriteString(split);
	file.WriteString(m_Addaddress);
	file.WriteString(split);
	file.WriteString(m_Addsalary);
	file.WriteString(split);
	file.WriteString(m_Addbonus);
	file.WriteString(split);
	file.WriteString(m_Addalimoney);
	file.WriteString(split);
	file.Close();
	UpdateData(false);

	Add::EndDialog (0);
	
	
}

void Add::OnAddname() 
{
	// TODO: If this is a RICHEDIT control, the control will not
	// send this notification unless you override the CDialog::OnInitDialog()
	// function and call CRichEditCtrl().SetEventMask()
	// with the ENM_CHANGE flag ORed into the mask.
	
	// TODO: Add your control notification handler code here
	
}

void Add::OnButton2() 
{
	// TODO: Add your control notification handler code here
	Add::EndDialog (0);
}

void Add::OnPaint() 
{
	CPaintDC dc(this); // device context for painting
	
	// TODO: Add your message handler code here

	
	// Do not call CDialog::OnPaint() for painting messages
}

HBRUSH Add::OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor) 
{
	HBRUSH hbr = CDialog::OnCtlColor(pDC, pWnd, nCtlColor);
	
	// TODO: Change any attributes of the DC here
	if (nCtlColor == CTLCOLOR_BTN)          //更改按钮颜色  
    {  
        //pDC->SetBkMode(TRANSPARENT);  
        pDC->SetTextColor(RGB(0, 0, 0));  
        pDC->SetBkColor(RGB(1, 121, 255));  
        HBRUSH b = CreateSolidBrush(RGB(121, 121, 255));  
        return b;  
    }  
    else if (nCtlColor == CTLCOLOR_SCROLLBAR)  //  
    {  
        //pDC->SetBkMode(TRANSPARENT);  
        pDC->SetTextColor(RGB(0, 0, 0));  
        pDC->SetBkColor(RGB(233, 233, 220));  
        HBRUSH b = CreateSolidBrush(RGB(233, 233, 220));  
        return b;  
    }  
    else if (nCtlColor == CTLCOLOR_EDIT)   //更改编辑框  
    {  
        //pDC->SetBkMode(TRANSPARENT);  
        pDC->SetTextColor(RGB(0, 0, 0));  
        pDC->SetBkColor(RGB(246, 246, 246));  
        HBRUSH b = CreateSolidBrush(RGB(246, 246, 246));  
        return b;  
    }  
    else if (nCtlColor == CTLCOLOR_STATIC)  //更改静态文本  
    {  
        pDC->SetTextColor(RGB(0, 0, 0));  
        pDC->SetBkColor(RGB(217, 226, 241));  
        HBRUSH b = CreateSolidBrush(RGB(217, 226, 241));  
        return b;  
    }  
    else if (nCtlColor == CTLCOLOR_DLG)   //更改对话框背景色  
    {  
        pDC->SetTextColor(RGB(0, 0, 0));  
        pDC->SetBkColor(RGB(166, 254, 1));  
        HBRUSH b = CreateSolidBrush(RGB(213, 226, 240));  
        return b;  
    }  

	
	// TODO: Return a different brush if the default is not desired
	return hbr;
}
