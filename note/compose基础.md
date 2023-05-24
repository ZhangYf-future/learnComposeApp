## Compose基础

### 创建项目

在最新版本的AndroidStudio中已经支持创建`Compose`模板项目了，创建成功之后可以直接运行该项目。

### 可组合函数

`JetPackCompose`是围绕可组合函数构建的，这些函数用来以程序化的方式定义应用的界面，我们只需要描述应用界面的外观并提供数据依赖项，而不必关心界面的构建过程。创建可组合函数，只需要将 `@Composable`注解添加到函数名称中即可:

```kotlin
    @Composable
    fun ShowText(content: String){
        Text(text = content)
    }
```

在上面的代码中就定义了一个可组合函数，这个函数可以用来显示一个文本信息。`Compose`使用kotlin编译器插件将可组合函数转换为应用的界面元素。例如上面的代码中的`Text`是由`Compose`界面库定义的一个组件，可以用来在屏幕上显示文本标签。

下面的代码按照官方的文档定义了一个`MessageCard`可组合函数:

```kotlin
    @Composable
    fun MessageCard(name: String){
        Text(text = "Hello $name")
    }
```

定义了相关的可组合函数之后，可以在`setContent`方法中使用这个可扩展函数，运行程序就可以看到效果了:

```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ShowText(content = "Hello Compose")
            MessageCard(name = "Compose")
        }
    }
```

### 预览可扩展函数

为了避免每次都运行项目才能看到执行效果，可以使用AndroidStudio提供的预览功能，通过在一个函数上添加`@Preview`注解，就可以直接预览相应的可扩展函数的效果:

```kotlin
    @Preview
    @Composable
    fun PreviewMessageCard(){
        MessageCard(name = "John")
        ShowText(content = "Preview")
    }
```

使用上面的可组合函数之后，就可以在旁边的预览窗口中观察到相应的效果了。但是当改变预览函数中的内容的时候，还是需要点击刷新按钮经过一次build之后才能看到最新的修改，并不是很好用。

## 布局

上面学习了可组合函数的使用，可以看到，可组合函数就是用来描述应用界面的组件，类似于在View体系中的`TextView`等。在View体系中，通常会使用`LinearLayout`等组件来对子View进行布局。在`Compose`中，界面元素也是采用多层次结构，元素中又包含其它元素。可以通过从可组合函数中调用其它可组合函数来构建界面层次结构。

### 添加多个文本

在上面的代码中，定义了一个`MessageCard`来显示一个文本，但是其实是期望能够构建一个消息界面，这个界面上不仅有用户的名字，还有消息内容，因此这里还需要一个文本组件来显示消息内容。

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Text(text = messageEntity.userName)
        Text(text = messageEntity.content)
    }
```

修改之后，首先定义了一个消息实体数据类，其中包含用户名称和消息内容，同时在`MessageCard`可组合函数中增加了一个`Text`来显示消息内容。

但是直接运行上面的代码将会看到两个文本的内容叠加在一起了，这是因为没有给这两个`Text`提供任何的布局方式。

### 使用布局

和View体系中一样，在`Compose`中也提供了多种布局方式可组合函数，使用这些可组合函数可以对其中的子可组合函数进行相应规则的布局，其中有三种基本的布局可组合项:

* `Column`: 垂直排列元素
* `Row`: 水平排列元素
* `Box`: 堆叠元素

对`MessageCard`中的子元素使用`Column`布局，如下代码所示:

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Column{
            Text(text = messageEntity.userName)
            Text(text = messageEntity.content)
        }
    }
```

可以看到非常简单，就是直接在外面添加一个`Column`即可，再次运行程序或者直接预览可以看到如下的效果:

![使用Column排列子元素](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E4%BD%BF%E7%94%A8Column%E6%8E%92%E5%88%97%E5%AD%90%E5%85%83%E7%B4%A0.png "使用Column排列子元素")

同时也可以看一下`Row`和`Box`的效果:

![使用Row排列子元素](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E4%BD%BF%E7%94%A8Row%E6%8E%92%E5%88%97%E5%AD%90%E5%85%83%E7%B4%A0.png "使用Row排列子元素")

![使用Box排列子元素](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E4%BD%BF%E7%94%A8Box%E6%8E%92%E5%88%97%E5%AD%90%E5%85%83%E7%B4%A0.png "使用Box排列子元素")

### 添加图片元素

布局元素中也可以包含布局元素，这样可以完成更加复杂的布局，现在希望在`MessageCard`中再显示一个用户的头像，并且用户的头像在用户名称和消息内容的左边，这种情况下就可以使用`Row`嵌套`Column`来实现。

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Row {
            Image(
                painter = painterResource(id = messageEntity.avatarResId),
                contentDescription = "用户头像"
            )
            Column {
                Text(text = messageEntity.userName)
                Text(text = messageEntity.content)
            }
        }
    }
```

在上面的代码中首先是一个横向布局，其中左边是用户头像，右边是一个垂直布局，其中上边是用户名称，下边是消息信息。运行后可以看到如下的效果:

![添加图片元素](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E6%B7%BB%E5%8A%A0%E5%9B%BE%E7%89%87%E5%85%83%E7%B4%A0.png "添加图片元素")

### 配置布局

上面的UI看起来不太协调，图片较大而右边的文字内容较少，为了装饰或者配置可组合项，`Compose`提供了`Modifier修饰符`，通过修饰符，可以修改可组合项的大小，布局，外观，还可以使元素可点击。通过将修饰符链接起来，可以创建更丰富的组合项，例如可以对上面的可组合项进行如下的修改:

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Row {
            Image(
                painter = painterResource(id = messageEntity.avatarResId),
                contentDescription = "用户头像",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = messageEntity.userName)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = messageEntity.content)
            }
        }
    }
```

在上面的代码中，首先指定了用户头像的尺寸大小，接着对用户头像进行圆形裁剪，同时在不同的子元素之间添加的空隙，运行上面的程序可以看到如下的效果:

![配置布局](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E9%85%8D%E7%BD%AE%E5%B8%83%E5%B1%80.png "配置布局")

## 使用Material Design

消息设计现在已经较为完善，但还不是特别理想，比如现在还不支持黑色模式等。`Compose`原生提供Material Design及其界面元素的实现，现在可以使用Material Design来改进消息设计。

在创建项目的时候，模板工程中本身会创建`ui.theme`包，这个包下有已经预创建的一些主题相关的参数，比如Color,Shape,Type和Theme,其中Theme中已经创建了一个`$当前项目名称Theme`的主题，这个主题中已经支持了黑色模式。可以直接使用这个主题和`Surface`来封装可组合项，如下所示:

```kotlin
        setContent {
            LearnComposeAppTheme {
                Surface {
                    MessageCard(MessageEntity("userName", "content", R.drawable.avatar))
                }
            }
        }
```

在`Preview`可组合函数中和`setContent`中做相同的修改之后就可以看到预览效果。

经过上面的修改，可组合项即可沿用应用主题中定义的样式，从而在整个应用中确保一致性。Material Design围绕`Color`,`Typography`,`Shape`三大要素进行构建。

### 设置颜色

通过使用`MaterialTheme.colors`可以获取封装在主题中的颜色信息，可以在任何需要设置颜色的位置使用这些颜色信息，下面的修改为用户头像添加了一个边框并设置边框颜色，同时为用户名称文本设置了一个颜色:

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Row {
            Image(
                painter = painterResource(id = messageEntity.avatarResId),
                contentDescription = "用户头像",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = messageEntity.userName, color = MaterialTheme.colors.secondaryVariant)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = messageEntity.content)
            }
        }
    }
```

运行上面的代码可以看到如下的效果:

![设置主题中的颜色](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E8%AE%BE%E7%BD%AE%E4%B8%BB%E9%A2%98%E4%B8%AD%E7%9A%84%E9%A2%9C%E8%89%B2.png "设置主题中的颜色")

### 设置排版

通过获取`MaterialTheme.typography`来为`Text`设置排版信息，如下代码所示:

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Row {
            Image(
                painter = painterResource(id = messageEntity.avatarResId),
                contentDescription = "用户头像",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = messageEntity.userName,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = messageEntity.content, style = MaterialTheme.typography.body2)
            }
        }
    }
```

![设置排版](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E8%AE%BE%E7%BD%AE%E6%8E%92%E7%89%88.png "设置排版")

### 设置形状

可以将消息内容封装在一个`Surface`中，这样就可以单独定义消息内容的形状和高度，同时也可以添加内边距等:

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Row {
            Image(
                painter = painterResource(id = messageEntity.avatarResId),
                contentDescription = "用户头像",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = messageEntity.userName,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(3.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                    Text(
                        text = messageEntity.content,
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
```

![设置形状](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E8%AE%BE%E7%BD%AE%E5%BD%A2%E7%8A%B6.png "设置形状")

### 启用黑色模式

由于支持Material Design,`Compose`默认能够支持黑色模式，使用Material Design颜色，文本和背景时，系统会自动适应黑色模式。可以在文件中以单独函数的形式创建多个预览，也可以向同一个函数中添加多个注解，下面通过添加新的预览注解来启用黑色模式。

```kotlin
    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        LearnComposeAppTheme {
            Surface {
                MessageCard(MessageEntity("测试用户名", "测试消息内容", R.drawable.avatar))
            }
        }
    }
```

由于这里创建了多个预览，因此在AndroidStudio的预览窗口中会存在多个预览实例，可以很方便的查看不同配置下的预览的显示信息:

![使用黑色模式](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E4%BD%BF%E7%94%A8%E9%BB%91%E8%89%B2%E6%A8%A1%E5%BC%8F.png "使用黑色模式")

在模拟器中开启黑色模式之后，运行情况如下:

![使用黑色模式-模拟器](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E4%BD%BF%E7%94%A8%E9%BB%91%E8%89%B2%E6%A8%A1%E5%BC%8F-%E6%A8%A1%E6%8B%9F%E5%99%A8.png "使用黑色模式-模拟器")

## 列表和动画

### 创建消息列表

上面的代码中消息窗中只有一个消息信息，一般情况下，消息列表中都会存在多个消息信息，为了能够显示非常多的消息信息，在`Compose`中可以使用`LazyColumn`和`LazyRow`来创建列表。这些可组合项只会呈现屏幕上显示的元素，因此，对于较长的列表，使用它们会非常高效，如下所示:

```kotlin
    @Composable
    fun Conversation(messageList: List<MessageEntity>){
        LazyColumn {
            items(messageList){
                MessageCard(messageEntity = it)
            }
        }
    }
```

在上面的代码中，可以看到`LazyColumn`包含一个`items`子项，它接受`List`作为参数，并且其最后还有一个Lambda表达式参数，该参数是`MessageEntity`的实例。也就是说，系统会针对提供的`List`的每个项调用此lambda。

![创建消息列表](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E5%88%9B%E5%BB%BA%E6%B6%88%E6%81%AF%E5%88%97%E8%A1%A8.png "创建消息列表")

### 切换消息显示

很多时候消息内容过长的情况下都不会直接显示全部的消息内容，而是会将消息内容折叠起来，当用户点击某一个消息的时候才会将消息内容展开。为了实现这个功能，首先需要让消息列表项目可以点击，其次需要记录当前消息项目处于打开还是关闭状态，为了记录这个状态，需要使用`remember`和`mutableStateOf`函数。

可组合函数使用`remember`将本地状态存储在内存中，并跟踪传递给`mutableStateOf`的值的变化。该值更新时，系统会自动重新绘制使用此状态的可组合项及其子项，从而更新界面，这就是重组。下面的代码演示了重组:

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Row(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 8.dp)) {
            Image(
                painter = painterResource(id = messageEntity.avatarResId),
                contentDescription = "用户头像",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            var isExpanded by remember {
                mutableStateOf(false)
            }
            Column(modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }) {
                Text(
                    text = messageEntity.userName,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(3.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                    Text(
                        text = messageEntity.content,
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.body2,
                        maxLines = if(isExpanded){
                            Int.MAX_VALUE
                        }else{
                            1
                        }
                    )
                }
            }
        }
    }
```

在上面的代码中首先通过`Modifier.clickable`来设置点击事件，同时通过`isExpanded`参数来表示当前的消息是否处于打开状态，通过这个参数来设置`Text`最大显示行数。运行上面的代码，可以看到如下的效果:

![切换消息显示](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E5%88%87%E6%8D%A2%E6%B6%88%E6%81%AF%E6%98%BE%E7%A4%BA.gif "切换消息显示")


### 使用动画

上面的切换动画比较生硬，在下面将通过使用动画修改子元素的背景颜色和尺寸来切换消息是否显示，将会使用`animateColorAsState`和`animateContentSize`来实现这样的效果:

```kotlin
    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = messageEntity.avatarResId),
                contentDescription = "用户头像",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            var isExpanded by remember {
                mutableStateOf(false)
            }
            val color by animateColorAsState(
                if (isExpanded) {
                    MaterialTheme.colors.primary
                } else {
                    MaterialTheme.colors.surface
                }
            )
            Column(modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }) {
                Text(
                    text = messageEntity.userName,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(3.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = color,
                    modifier = Modifier.animateContentSize()
                ) {
                    Text(
                        text = messageEntity.content,
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.body2,
                        maxLines = if (isExpanded) {
                            Int.MAX_VALUE
                        } else {
                            1
                        }
                    )
                }
            }
        }
    }
```

运行上面的代码，可以看到如下的效果:

![使用动画打开消息信息](https://zhangyifanimage.oss-cn-chengdu.aliyuncs.com/%E4%BD%BF%E7%94%A8%E5%8A%A8%E7%94%BB%E6%89%93%E5%BC%80%E6%B6%88%E6%81%AF%E4%BF%A1%E6%81%AF.gif "使用动画打开消息信息")