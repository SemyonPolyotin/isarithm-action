# Isarithm action
Action Java Spring REST web service for Isarithm

## Installation
```bash
    $ git clone https://github.com/matthewpoletin/isarithm-action.git
    $ cd isarithm-action
    $ gradle bootJar
    $ scp ./build/libs/isarithm-action.jar isarithm@vds1.isarithm.ru:/var/www/isarithm/isarithm-action.jar
    $ ssh -f isarithm@vds1.isarithm.ru 'nohup java -Dserver.port=4003 -jar /var/www/isarithm/isarithm-action.jar --spring.profiles.active=prod >/dev/null 2>&1 &'
```

## Restart
```fish
    ssh -f isarithm@vds1.isarithm.ru 'kill -15 (ps aux | grep 'isarithm-action.jar' | grep -v grep | awk \'{print $2}\')'
```
