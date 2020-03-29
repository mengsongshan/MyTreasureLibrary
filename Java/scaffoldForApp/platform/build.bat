@echo off
@rem ***********************************************************
@rem *脚本根据提供的项目名称，项目所属组名称以及项目包路径创建 *
@rem *基本项目目录结构                                         *
@rem ***********************************************************

@rem aquire base var
set /p prjHome=please enter project Name : 
set /p groupId=please enter project groupId :
set /p package=please enter project package :

@rem replace . to \
set "package=%package:.=\%"

@rem del file and folder  
del /q /s %prjHome%
rd /q /s %prjHome% 


@rem biuld project base Directory
mkdir %prjHome%\src\main\java
mkdir %prjHome%\src\test\java
mkdir %prjHome%\src\main\java\%package%
mkdir %prjHome%\src\test\java\%package%

@rem copy base pom.xml to current project home
copy c:\\pom.xml %prjHome%\

for /f %%i in (%prjHome%\pom.xml) do echo %%i 
  

  