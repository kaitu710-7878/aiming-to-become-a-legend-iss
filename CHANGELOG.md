# Changelog / 変更履歴

All notable changes to **Aiming to become a legend-ISS** will be documented in this file.

---

## [1.0.0-beta] - 2026-11-09

### English
- **Initial Release:** Official addon for **Aiming to become a legend**, integrating with **Iron's Spells 'n Spellbooks** (ISS).
- **Permanent Magic Attributes Progression:** Automatically synchronizes with legend milestones without any Mixins or bytecode hacks.
  - Mana Regeneration: `+5.0%` per tier (`irons_spellbooks:mana_regen`)
  - Spell Power: `+5.0%` per tier (`irons_spellbooks:spell_power`)
  - Max Mana: `+20.0` per tier (`irons_spellbooks:max_mana`)
  - Cooldown Reduction: `+5.0%` per tier (`irons_spellbooks:cooldown_reduction`)
  - Cast Time Reduction: `+5.0%` per tier (`irons_spellbooks:cast_time_reduction`)
  - Spell Resistance: `+1.0%` per tier (`irons_spellbooks:spell_resist`)
- **Non-Invasive Event Pipeline:** Triggers synchronously on milestone events via Forge's event bus (`EventPriority.LOWEST`) alongside login/respawn syncing.
- **Commands Added:**
  - `/legend-iss` or `/legend-iss status`: Displays current tier and active magic bonuses.
  - `/legend-iss sync`: Manually refreshes and re-applies magic attribute modifiers.
- **Bilingual Localization:** Full English and Japanese language support included.

### 日本語 (Japanese)
- **初回リリース:** **Aiming to become a legend** の公式アドオンとして、**Iron's Spells 'n Spellbooks** (ISS) との完全連携を実現。
- **永続魔法ステータス強化:** Mixin等の強引な改変を行わず、元MODの条件達成トリガーと自然に連動して別枠永続バフを付与。
  - マナ再生: 1段階ごとに `+5.0%` (`irons_spellbooks:mana_regen`)
  - 魔法威力: 1段階ごとに `+5.0%` (`irons_spellbooks:spell_power`)
  - 最大マナ: 1段階ごとに `+20.0` (`irons_spellbooks:max_mana`)
  - クールダウン短縮: 1段階ごとに `+5.0%` (`irons_spellbooks:cooldown_reduction`)
  - 詠唱時間短縮: 1段階ごとに `+5.0%` (`irons_spellbooks:cast_time_reduction`)
  - 魔法耐性: 1段階ごとに `+1.0%` (`irons_spellbooks:spell_resist`)
- **安全なイベント連動パイプライン:** Forgeイベントバスの最低優先度(`EventPriority.LOWEST`)を活用し、元MODの進捗更新直後に安全にステータスを同期。ログインやリスポーン時にも確実に維持。
- **専用コマンド実装:**
  - `/legend-iss` または `/legend-iss status`: 現在の段階と適用中のISS魔法ボーナス一覧を表示。
  - `/legend-iss sync`: 魔法属性修飾子を手動で再計算・同期。
- **日英バイリンガル対応:** 日本語および英語の言語ファイル・ドキュメントを同梱。
