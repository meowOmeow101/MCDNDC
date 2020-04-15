# MCDNDC
MinecraftDoNotDoChallenge  
当前版本:v0.1(Alpha)  
##插件功能
一个能在MC中实现一种小游戏(不要做挑战)的插件
##前置插件
```
TAB 最新版本 - 可以在 https://www.spigotmc.org/resources/57806/ 获取
```
##插件指令
```text
/dndc(/dnd) - 插件主命令
子命令:
  reload - 重载词库&配置文件
  next   - 从词库抽取词语
  help   - 帮助页面
```
## 插件权限
```text
dndc.reload - 允许重载词库&配置文件
dndc.play   - 允许进行游玩
```
##配置文件
```yaml
####################
#MCDNDC V0.1 Config File
#作者:jingwenMC
#开源许可:GPLv3
#版本:v0.1
####################

#Name:配置文件版本
#Note:此项用于配置文件结构版本的确认。为防止出错，请不要自行更改
#Updated:v0.1
config_version: 1

#Name:选择语言
#Note:在1.0版本前没有任何作用
#WillUpdate:v1.0
lang: 'zh_CN'

#Name:词库列表
#Note:请按照第一次释放配置时的格式填写,避免出错
#Updated:v0.1
words:
  - 'Word1'
  - 'Word2'
  - 'Word3'
```