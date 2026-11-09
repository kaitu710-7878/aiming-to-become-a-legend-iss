# Aiming to become a legend-ISS

[![Minecraft 1.20.1](https://img.shields.io/badge/Minecraft-1.20.1-brightgreen.svg)]()
[![Forge](https://img.shields.io/badge/Modloader-Forge%2047.3.0+-orange.svg)]()
[![Release](https://img.shields.io/badge/Release-Beta-blueviolet.svg)]()
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](LICENSE)

[English](#english) | [日本語](#日本語-japanese)

---

## English

### Overview
**Aiming to become a legend-ISS** is an official addon mod for **Aiming to become a legend**, integrating seamlessly with **Iron's Spells 'n Spellbooks** (ISS) for Minecraft 1.20.1 (Forge).

Whenever you advance in your legendary journey by completing advancements, slaying unique mobs, and eating diverse delicacies, you now simultaneously unlock permanent magical enhancements in addition to your base physical progression.

### Features
- **Permanent Magic Attribute Progression:**  
  For each milestone tier gained in *Aiming to become a legend* (by default every 5 total points), you permanently gain:
  - **Mana Regeneration:** `+5.0%` (`irons_spellbooks:mana_regen`)
  - **Spell Power:** `+5.0%` (`irons_spellbooks:spell_power`)
  - **Max Mana:** `+20.0` (`irons_spellbooks:max_mana`)
  - **Cooldown Reduction:** `+5.0%` (`irons_spellbooks:cooldown_reduction`)
  - **Cast Time Reduction:** `+5.0%` (`irons_spellbooks:cast_time_reduction`)
  - **Spell Resistance:** `+1.0%` (`irons_spellbooks:spell_resist`)

- **Non-Invasive Architecture (Zero Mixins):**  
  No bytecode manipulation or aggressive Mixins. The addon synchronizes on Forge's event bus immediately after the base mod establishes milestone tiers, cleanly storing and managing dedicated attribute modifiers.

- **Commands:**
  - `/legend-iss` or `/legend-iss status` - Display your current legend tier and active ISS magic stats.
  - `/legend-iss status <player>` - Check another player's magic stats (Operator permission level 2).
  - `/legend-iss sync` - Force recalculate and refresh magic attribute modifiers.

### Requirements & Installation
1. Install [Minecraft Forge](https://files.minecraftforge.net/) for 1.20.1 (47.3.0 or higher).
2. Install **Aiming to become a legend** (1.0.0 or higher).
3. Install **Iron's Spells 'n Spellbooks** (1.20.1-2.0.0 or higher).
4. Place `aiming_to_become_a_legend_iss-1.0.0-beta.jar` into your `.minecraft/mods` folder.

---

## 日本語 (Japanese)

### 概要
**Aiming to become a legend-ISS** は、成長系MOD「**Aiming to become a legend**」と大人気魔法MOD「**Iron's Spells 'n Spellbooks** (ISS)」を連動させる公式アドオンMODです (Minecraft 1.20.1 Forge対応)。

冒険を通じて実績を解除し、未知のモブを討伐し、多様な食事を口にすることで、物理ステータスだけでなく強力な魔法能力も永久に強化されていきます。

### 主な特徴
- **永続的な魔法ステータス強化:**  
  元MOD「Aiming to become a legend」の段階（Tier）が上がるごと（デフォルトでは合計5ポイントごと）に、以下の魔法能力が永久に加算されます。
  - **マナ再生:** `+5.0%` (`irons_spellbooks:mana_regen`)
  - **魔法威力:** `+5.0%` (`irons_spellbooks:spell_power`)
  - **最大マナ:** `+20.0` (`irons_spellbooks:max_mana`)
  - **クールダウン短縮:** `+5.0%` (`irons_spellbooks:cooldown_reduction`)
  - **詠唱時間短縮:** `+5.0%` (`irons_spellbooks:cast_time_reduction`)
  - **魔法耐性:** `+1.0%` (`irons_spellbooks:spell_resist`)

- **非侵襲・完全クリーン設計 (Mixin不使用):**  
  Mixin等の強引なバイトコード書き換えは一切行いません。元MODの条件達成処理の完了直後にForgeイベントバス(`EventPriority.LOWEST`)で自然にトリガーし、独立した専用UUIDで別枠の永続アトリビュートモディファイアを付与します。競合やクラッシュの心配がなく安心・安全です。

- **コマンド:**
  - `/legend-iss` または `/legend-iss status` - 現在の段階と適用中のISS魔法ステータスボーナスを表示。
  - `/legend-iss status <player>` - 他のプレイヤーの魔法ステータスを確認（OP権限レベル2以上）。
  - `/legend-iss sync` - 魔法属性修飾子を手動で再計算・同期。

### 前提MODおよび導入手順
1. Minecraft 1.20.1 用の [Minecraft Forge](https://files.minecraftforge.net/) (47.3.0以上推奨) を導入。
2. **Aiming to become a legend** (1.0.0以上) を導入。
3. **Iron's Spells 'n Spellbooks** (1.20.1-2.0.0以上) を導入。
4. ビルドされた `aiming_to_become_a_legend_iss-1.0.0-beta.jar` を `.minecraft/mods` に配置。
