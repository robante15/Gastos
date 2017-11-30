!include "FileFunc.nsh"
!include "MUI.nsh"
!include "WinMessages.nsh"
 
!define COMPANY_NAME "UES-FMO"
!define ANHO "2017"
!define MUI_ICON "icono.ico"
!define JAR "Gastos.jar"
!define ID "11C7BF"
 
!insertmacro MUI_LANGUAGE "Spanish"
 
OutFile "Finanzas Personales.exe"
 
Name "Finanzas Personales"
 
SilentInstall Silent
 
  VIProductVersion "1.0.0.0"
  VIAddVersionKey /LANG=${LANG_SPANISH} "FileDescription" "Programa de Finanzas"
  VIAddVersionKey /LANG=${LANG_SPANISH} "LegalCopyright" "©${COMPANY_NAME} ${ANHO}"
  VIAddVersionKey /LANG=${LANG_SPANISH} "LegalTrademarks" "${COMPANY_NAME}"
  VIAddVersionKey /LANG=${LANG_SPANISH} "ProductName" "Finanzas Pro"
  VIAddVersionKey /LANG=${LANG_SPANISH} "InternalName" "${COMPANY_NAME}"
  VIAddVersionKey /LANG=${LANG_SPANISH} "OriginalFilename" "${COMPANY_NAME}"
  VIAddVersionKey /LANG=${LANG_SPANISH} "CompanyName" "${COMPANY_NAME}"
  VIAddVersionKey /LANG=${LANG_SPANISH} "FileVersion" "1.0"
  VIAddVersionKey /LANG=${LANG_SPANISH} "ProductVersion" 1.0"
 
RequestExecutionLevel user
 
Function .onInit
System::Call 'kernel32::CreateMutexA(i 0, i 0, t "${ID}") i .r1 ?e'
 Pop $R0
 StrCmp $R0 0 +3
   MessageBox MB_OK|MB_USERICON "El programa ya esta en ejecución"
   Abort
FunctionEnd
 
Caption "Finanzas Personales"
 
Section
        SetRegView 64
        Goto Lee
        Lee32:
                SetRegView 32
        Lee:
                ReadRegStr $1 HKLM "SOFTWARE\JavaSoft\Java Runtime Environment" "CurrentVersion"
                ReadRegStr $0 HKLM "SOFTWARE\JavaSoft\Java Runtime Environment\$1" "JavaHome"
                StrCmp $0 "" Lee32 0
        IfFileExists $0\bin\javaw.exe 0 NoJava
        IfFileExists ${JAR} 0 NoJAR
        ExecWait '$0\bin\javaw.exe -jar ${JAR}'
        Goto Fin
        NoJava:
                MessageBox MB_OK|MB_USERICON "No se encontró Java en este equipo"
       NoJAR:
                MessageBox MB_OK|MB_USERICON "No fue posible la ejecución de ${JAR}"
        Fin:
SectionEnd
