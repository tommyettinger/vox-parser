# vox-parser

A Java parser for the MagicaVoxel .vox format using libGDX

# What

[MagicaVoxel](https://ephtracy.github.io) is a great way to edit 3D models easily,
as individual colored cubes. If you want to read in a MagicaVoxel .vox file saved
relatively recently, you might be surprised at how complicated the format became,
compared to how it was around 2014-2018. Some help parsing the format is rather
useful now.

This provides a little of that help. You can load up a `VoxModel` using
`VoxParser.readVox()`, and from there you can get the various sub-models a .vox
file now consists of using `myModel.grids`. The .vox format allows various position
adjustments to those grids in a potentially very large space, even though each grid
is at most 256x256x256 voxels in size. Just going through everything .vox can do
would take a while... You may want to look at
[SpotVox](https://github.com/tommyettinger/spotvox) to see how it works with the
newer types of chunk. [This method is what uses a VoxModel there.](https://github.com/tommyettinger/spotvox/blob/main/core/src/main/java/com/github/tommyettinger/Renderer.java#L709-L736)
It uses different names, like VoxIOExtended is equivalent to VoxParser here.

## Get

vox-parser only depends on libGDX, currently 1.12.1 .

For most usage, this goes in your libGDX project's core dependencies:

```gradle
implementation "com.github.tommyettinger:vox-parser:0.0.1"
```

For GWT, it needs a sources dependency:

```gradle
implementation "com.github.tommyettinger:vox-parser:0.0.1:sources"
```

As well as this inherits line in your `GdxDefinition.gwt.xml` file:

```xml
<inherits name="com.github.tommyettinger.voxparser" />
```

This may or may not work on GWT. In any case, it relies on IO classes that
libGDX makes available.

## License

This project is licensed under the [Apache License 2.0](LICENSE).